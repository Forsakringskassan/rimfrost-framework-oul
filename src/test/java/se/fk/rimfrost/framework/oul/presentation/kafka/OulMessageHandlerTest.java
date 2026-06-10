package se.fk.rimfrost.framework.oul.presentation.kafka;

import io.quarkus.arc.DefaultBean;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import se.fk.rimfrost.Idtyp;
import se.fk.rimfrost.OperativtUppgiftslagerStatusMessage;
import se.fk.rimfrost.ProcessInfo;
import se.fk.rimfrost.framework.oul.logic.OulHandlerInterface;
import se.fk.rimfrost.framework.oul.logic.dto.ImmutableIdtyp;
import se.fk.rimfrost.framework.oul.logic.dto.ImmutableOulStatus;
import se.fk.rimfrost.framework.oul.logic.dto.ImmutableProcessInfo;
import se.fk.rimfrost.framework.oul.logic.dto.OulStatus;

import java.util.Map;
import java.util.UUID;

@QuarkusTest
public class OulMessageHandlerTest
{
   @InjectMock
   OulHandlerInterface oulHandlerInterface;

   @Inject
   OulMessageHandler oulMessageHandler;

   @Test
   public void consume_oul_status_should_call_oul_handler()
   {
      var payload = createOperativtUppgiftslagerStatusMessage();

      oulMessageHandler.consumeOulStatus(payload);
      Mockito.verify(oulHandlerInterface, Mockito.times(1)).handleOulStatus(createOulStatus(payload));
   }

   private OulStatus createOulStatus(OperativtUppgiftslagerStatusMessage oulStatusMessage)
   {
      var utforarId = ImmutableIdtyp.builder()
            .typId(oulStatusMessage.getUtforarId().getTypId())
            .varde(oulStatusMessage.getUtforarId().getVarde())
            .build();

      var processInfo = ImmutableProcessInfo.builder()
            .replyTopic(oulStatusMessage.getProcessInfo().getReplyTopic())
            .cloudeventAttributes(oulStatusMessage.getProcessInfo().getCloudeventAttributes())
            .build();

      return ImmutableOulStatus.builder()
            .handlaggningId(UUID.fromString(oulStatusMessage.getHandlaggningId()))
            .uppgiftId(UUID.fromString(oulStatusMessage.getUppgiftId()))
            .utforarId(utforarId)
            .uppgiftStatus(oulStatusMessage.getStatus())
            .processInfo(processInfo)
            .build();
   }

   private OperativtUppgiftslagerStatusMessage createOperativtUppgiftslagerStatusMessage()
   {
      var utforarId = new Idtyp();
      utforarId.setTypId(UUID.randomUUID().toString());
      utforarId.setVarde(UUID.randomUUID().toString());

      var processInfo = new ProcessInfo();
      processInfo.setReplyTopic("test-topic");
      processInfo.setCloudeventAttributes(Map.of("TestKey", "TestValue"));

      var operativtUppgiftslagerStatusMessage = new OperativtUppgiftslagerStatusMessage();
      operativtUppgiftslagerStatusMessage.setHandlaggningId(UUID.randomUUID().toString());
      operativtUppgiftslagerStatusMessage.setUppgiftId(UUID.randomUUID().toString());
      operativtUppgiftslagerStatusMessage.setStatus("TEST");
      operativtUppgiftslagerStatusMessage.setUtforarId(utforarId);
      operativtUppgiftslagerStatusMessage.setProcessInfo(processInfo);

      return operativtUppgiftslagerStatusMessage;
   }

   @ApplicationScoped
   @DefaultBean
   public static class TestOulHandler implements OulHandlerInterface
   {
      @Override
      public void handleOulStatus(OulStatus oulStatus)
      {
         // NO-OP
      }
   }
}
