package se.fk.rimfrost.framework.oul.integration.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.OnOverflow;
import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import se.fk.rimfrost.OperativtUppgiftslagerRequestMessage;
import se.fk.rimfrost.OperativtUppgiftslagerStatusMessage;
import se.fk.rimfrost.framework.oul.integration.kafka.dto.OulMessageRequest;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@SuppressWarnings("unused")
@ApplicationScoped
public class OulKafkaProducer
{
   @Inject
   OulKafkaMapper mapper;

   @Inject
   @Channel("operativt-uppgiftslager-requests")
   @OnOverflow(value = OnOverflow.Strategy.BUFFER, bufferSize = 1024)
   Emitter<OperativtUppgiftslagerRequestMessage> oulRequestEmitter;

   @Inject
   @Channel("operativt-uppgiftslager-status-control")
   @OnOverflow(value = OnOverflow.Strategy.BUFFER, bufferSize = 1024)
   Emitter<OperativtUppgiftslagerStatusMessage> oulStatusEmitter;

   public void sendOulRequest(OulMessageRequest messageRequest)
   {
      var request = mapper.toOulRequestMessage(messageRequest);
      var kafkaMetadata = OutgoingKafkaRecordMetadata.builder()
            .addHeaders(new RecordHeader("replyTo", messageRequest.replyToTopic().getBytes(StandardCharsets.UTF_8))).build();
      var message = Message.of(request).addMetadata(kafkaMetadata);

      oulRequestEmitter.send(message);
   }

   public void sendOulStatusUpdate(UUID uppgiftId, String status)
   {
      var message = new OperativtUppgiftslagerStatusMessage();
      message.setUppgiftId(uppgiftId.toString());
      message.setStatus(status);
      oulStatusEmitter.send(message);
   }
}
