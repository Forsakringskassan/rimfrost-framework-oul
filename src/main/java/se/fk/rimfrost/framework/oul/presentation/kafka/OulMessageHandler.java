package se.fk.rimfrost.framework.oul.presentation.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.fk.rimfrost.OperativtUppgiftslagerResponseMessage;
import se.fk.rimfrost.OperativtUppgiftslagerStatusMessage;

@ApplicationScoped
public class OulMessageHandler
{

   private static final Logger LOGGER = LoggerFactory.getLogger(OulMessageHandler.class);

   @Inject
   OulKafkaMapper mapper;

   @Inject
   Instance<OulHandlerInterface> oulHandlerInterface;

   public void consumeOulResponse(OperativtUppgiftslagerResponseMessage oulResponseMessage)
   {
      LOGGER.info("OperativtUppgiftslagerResponseMessage received with HandlaggningId: "
            + oulResponseMessage.getHandlaggningId());
      var oulResponse = mapper.toOulResponse(oulResponseMessage);
      oulHandlerInterface.get().handleOulResponse(oulResponse);
   }

   public void consumeOulStatus(OperativtUppgiftslagerStatusMessage oulStatusMessage)
   {
      LOGGER.info(
            "OperativtUppgiftslagerStatusMessage received with HandlaggningId: " + oulStatusMessage.getHandlaggningId());
      var oulStatus = mapper.toOulStatus(oulStatusMessage);
      oulHandlerInterface.get().handleOulStatus(oulStatus);
   }
}
