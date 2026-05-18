package se.fk.rimfrost.framework.oul.presentation.kafka;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.reactive.messaging.memory.InMemoryConnector;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.spi.Connector;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import se.fk.rimfrost.OperativtUppgiftslagerStatusMessage;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@QuarkusTest
public class OulConsumerTest
{
   private final static String oulStatusNotificationChannel = "operativt-uppgiftslager-status-notification";

   @InjectMock
   OulMessageHandler oulMessageHandler;

   @Inject
   @Connector("smallrye-in-memory")
   protected InMemoryConnector inMemoryConnector;

   @Test
   public void regel_consumer_should_call_regel_message_handler_on_incoming_request() throws InterruptedException
   {
      var operativtUppgiftslagerStatusMessage = new OperativtUppgiftslagerStatusMessage();
      operativtUppgiftslagerStatusMessage.setHandlaggningId(UUID.randomUUID().toString());
      operativtUppgiftslagerStatusMessage.setUppgiftId(UUID.randomUUID().toString());
      operativtUppgiftslagerStatusMessage.setStatus("TEST");

      inMemoryConnector.source(oulStatusNotificationChannel).send(operativtUppgiftslagerStatusMessage);
      TimeUnit.SECONDS.sleep(1);
      Mockito.verify(oulMessageHandler, Mockito.times(1)).consumeOulStatus(operativtUppgiftslagerStatusMessage);
   }
}
