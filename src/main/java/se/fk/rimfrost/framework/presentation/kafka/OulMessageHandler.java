package se.fk.rimfrost.framework.presentation.kafka;

import jakarta.enterprise.context.ApplicationScoped;
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
   OulHandlerInterface oulHandlerInterface;

   public void consumeOulResponse(OperativtUppgiftslagerResponseMessage oulResponseMessage)
   {
      LOGGER.info("OperativtUppgiftslagerResponseMessage received with KundbehovsflodeId: "
            + oulResponseMessage.getKundbehovsflodeId());
      var oulResponse = mapper.toOulResponse(oulResponseMessage);
      oulHandlerInterface.handleOulResponse(oulResponse);
   }

   public void consumeOulStatus(OperativtUppgiftslagerStatusMessage oulStatusMessage)
   {
      LOGGER.info(
            "OperativtUppgiftslagerStatusMessage received with KundbehovsflodeId: " + oulStatusMessage.getKundbehovsflodeId());
      var oulStatus = mapper.toOulStatus(oulStatusMessage);
      oulHandlerInterface.handleOulStatus(oulStatus);
   }
}
