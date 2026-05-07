package se.fk.rimfrost.framework.oul.integration.kafka;

import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import org.apache.kafka.common.header.Header;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.fk.rimfrost.OperativtUppgiftslagerRequestMessage;
import se.fk.rimfrost.OperativtUppgiftslagerStatusMessage;
import se.fk.rimfrost.Status;
import se.fk.rimfrost.framework.oul.integration.kafka.dto.OulMessageRequest;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Several tests use {@link ArgumentCaptor} to inspect arguments passed to mocked emitters.
 * The pattern is: declare a captor, pass {@code captor.capture()} inside {@code verify()},
 * then call {@code captor.getValue()} to retrieve the actual object and assert on its fields.
 * This is needed because the message objects are created inside the method under test,
 * so there is no reference to them before the call.
 */
@ExtendWith(MockitoExtension.class)
class OulKafkaProducerTest
{
   @Mock
   OulKafkaMapper mapper;

   @Mock
   Emitter<OperativtUppgiftslagerRequestMessage> oulRequestEmitter;

   @Mock
   Emitter<OperativtUppgiftslagerStatusMessage> oulStatusEmitter;

   @InjectMocks
   OulKafkaProducer producer;

   @Test
   void sendOulRequest_delegatesToMapper()
   {
      var request = mockRequest("reply-topic");
      when(mapper.toOulRequestMessage(request)).thenReturn(new OperativtUppgiftslagerRequestMessage());

      producer.sendOulRequest(request);

      verify(mapper).toOulRequestMessage(request);
   }

   @Test
   @SuppressWarnings("unchecked")
   void sendOulRequest_emitterReceivesMappedPayload()
   {
      var request = mockRequest("reply-topic");
      var mapped = new OperativtUppgiftslagerRequestMessage();
      when(mapper.toOulRequestMessage(request)).thenReturn(mapped);

      producer.sendOulRequest(request);

      ArgumentCaptor<Message<OperativtUppgiftslagerRequestMessage>> captor = ArgumentCaptor.forClass(Message.class);
      verify(oulRequestEmitter).send(captor.capture());
      assertThat(captor.getValue().getPayload()).isSameAs(mapped);
   }

   /**
    * OutgoingKafkaRecordMetadata is a SmallRye type that holds headers,
    * key, topic override, etc. Here we retrieve it from the captured message by type and then
    * inspect the {@code replyTo} header to verify the value.
    */
   @Test
   @SuppressWarnings("unchecked")
   void sendOulRequest_setsReplyToHeader()
   {
      var request = mockRequest("reply-topic");
      when(mapper.toOulRequestMessage(request)).thenReturn(new OperativtUppgiftslagerRequestMessage());

      producer.sendOulRequest(request);

      ArgumentCaptor<Message<OperativtUppgiftslagerRequestMessage>> captor = ArgumentCaptor.forClass(Message.class);
      verify(oulRequestEmitter).send(captor.capture());

      OutgoingKafkaRecordMetadata<?> metadata = captor.getValue()
            .getMetadata(OutgoingKafkaRecordMetadata.class)
            .orElseThrow();
      Header header = metadata.getHeaders().lastHeader("replyTo");
      assertThat(header).isNotNull();
      assertThat(new String(header.value(), StandardCharsets.UTF_8)).isEqualTo("reply-topic");
   }

   @Test
   void sendOulStatusUpdate_setsUppgiftId()
   {
      var id = UUID.randomUUID();

      producer.sendOulStatusUpdate(id, Status.NY);

      ArgumentCaptor<OperativtUppgiftslagerStatusMessage> captor = ArgumentCaptor
            .forClass(OperativtUppgiftslagerStatusMessage.class);
      verify(oulStatusEmitter).send(captor.capture());
      assertThat(captor.getValue().getUppgiftId()).isEqualTo(id.toString());
   }

   @ParameterizedTest
   @EnumSource(Status.class)
   void sendOulStatusUpdate_setsStatus(Status status)
   {
      producer.sendOulStatusUpdate(UUID.randomUUID(), status);

      ArgumentCaptor<OperativtUppgiftslagerStatusMessage> captor = ArgumentCaptor
            .forClass(OperativtUppgiftslagerStatusMessage.class);
      verify(oulStatusEmitter).send(captor.capture());
      assertThat(captor.getValue().getStatus()).isEqualTo(status);
   }

   @Test
   void sendOulStatusUpdate_sendsExactlyOnce()
   {
      producer.sendOulStatusUpdate(UUID.randomUUID(), Status.NY);

      verify(oulStatusEmitter, times(1)).send(any(OperativtUppgiftslagerStatusMessage.class));
   }

   private OulMessageRequest mockRequest(String replyToTopic)
   {
      var request = mock(OulMessageRequest.class);
      when(request.replyToTopic()).thenReturn(replyToTopic);
      return request;
   }
}
