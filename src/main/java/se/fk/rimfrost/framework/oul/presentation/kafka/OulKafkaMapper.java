package se.fk.rimfrost.framework.oul.presentation.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.OperativtUppgiftslagerResponseMessage;
import se.fk.rimfrost.OperativtUppgiftslagerStatusMessage;
import se.fk.rimfrost.Status;
import se.fk.rimfrost.framework.oul.logic.dto.*;
import java.util.UUID;

@ApplicationScoped
public class OulKafkaMapper
{

   public OulResponse toOulResponse(OperativtUppgiftslagerResponseMessage oulResponseMessage)
   {
      return ImmutableOulResponse.builder()
            .handlaggningId(UUID.fromString(oulResponseMessage.getHandlaggningId()))
            .uppgiftId(UUID.fromString(oulResponseMessage.getUppgiftId()))
            .build();
   }

   public OulStatus toOulStatus(OperativtUppgiftslagerStatusMessage oulStatusMessage)
   {

      return ImmutableOulStatus.builder()
            .handlaggningId(UUID.fromString(oulStatusMessage.getHandlaggningId()))
            .uppgiftId(UUID.fromString(oulStatusMessage.getUppgiftId()))
            .utforarId(toIdtyp(oulStatusMessage.getUtforarId()))
            .uppgiftStatus(mapStatus(oulStatusMessage.getStatus()))
            .cloudeventAttributes(oulStatusMessage.getCloudeventAttributes())
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

   private UppgiftStatus mapStatus(Status status)
    {
        return switch (status) {
            case NY -> UppgiftStatus.NY;
            case TILLDELAD -> UppgiftStatus.TILLDELAD;
            case AVSLUTAD -> UppgiftStatus.AVSLUTAD;
            case AVBRUTEN -> UppgiftStatus.AVBRUTEN;
        };
    }
}
