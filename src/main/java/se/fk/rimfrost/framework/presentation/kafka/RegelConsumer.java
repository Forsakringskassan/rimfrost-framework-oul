package se.fk.rimfrost.framework.presentation.kafka;

import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import se.fk.rimfrost.OperativtUppgiftslagerResponseMessage;
import se.fk.rimfrost.OperativtUppgiftslagerStatusMessage;

@ApplicationScoped
public class RegelConsumer
{

   @Inject
   RegelMessageHandler handler;


   @Incoming("operativt-uppgiftslager-responses")
   @Blocking
   public void onOulResponse(OperativtUppgiftslagerResponseMessage oulResponseMessage)
   {
      handler.consumeOulResponse(oulResponseMessage);
   }

   @Incoming("operativt-uppgiftslager-status-notification")
   @Blocking
   public void onOulStatusMessage(OperativtUppgiftslagerStatusMessage oulStatusMessage)
   {
      handler.consumeOulStatus(oulStatusMessage);
   }

}
