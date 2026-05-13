package se.fk.rimfrost.framework.oul.presentation.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.fk.rimfrost.OperativtUppgiftslagerStatusMessage;
import se.fk.rimfrost.framework.oul.logic.OulHandlerInterface;

@ApplicationScoped
public class OulMessageHandler
{

   private static final Logger LOGGER = LoggerFactory.getLogger(OulMessageHandler.class);

   @Inject
   OulKafkaMapper mapper;

   @Inject
   Instance<OulHandlerInterface> oulHandlerInterface;

   public void consumeOulStatus(OperativtUppgiftslagerStatusMessage oulStatusMessage)
   {
      LOGGER.info(
            "OperativtUppgiftslagerStatusMessage received with HandlaggningId: " + oulStatusMessage.getHandlaggningId());
      var oulStatus = mapper.toOulStatus(oulStatusMessage);
      oulHandlerInterface.get().handleOulStatus(oulStatus);
   }
}
