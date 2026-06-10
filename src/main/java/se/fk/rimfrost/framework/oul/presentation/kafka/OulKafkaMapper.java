package se.fk.rimfrost.framework.oul.presentation.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.OperativtUppgiftslagerStatusMessage;
import se.fk.rimfrost.framework.oul.logic.dto.*;
import java.util.UUID;

@ApplicationScoped
public class OulKafkaMapper
{

   public OulStatus toOulStatus(OperativtUppgiftslagerStatusMessage oulStatusMessage)
   {

      var processInfo = ImmutableProcessInfo.builder()
            .replyTopic(oulStatusMessage.getProcessInfo().getReplyTopic())
            .cloudeventAttributes(oulStatusMessage.getProcessInfo().getCloudeventAttributes())
            .build();

      return ImmutableOulStatus.builder()
            .handlaggningId(UUID.fromString(oulStatusMessage.getHandlaggningId()))
            .uppgiftId(UUID.fromString(oulStatusMessage.getUppgiftId()))
            .utforarId(toIdtyp(oulStatusMessage.getUtforarId()))
            .uppgiftStatus(oulStatusMessage.getStatus())
            .processInfo(processInfo)
            .planeradTill(oulStatusMessage.getPlaneradTill())
            .build();
   }

   private Idtyp toIdtyp(se.fk.rimfrost.Idtyp idtyp)
   {
      if (idtyp == null)
      {
         return null;
      }

      return ImmutableIdtyp.builder()
            .typId(idtyp.getTypId())
            .varde(idtyp.getVarde())
            .build();
   }

}
