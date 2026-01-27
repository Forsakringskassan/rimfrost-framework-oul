package se.fk.rimfrost.framework.presentation.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.OperativtUppgiftslagerResponseMessage;
import se.fk.rimfrost.OperativtUppgiftslagerStatusMessage;
import se.fk.rimfrost.Status;
import se.fk.rimfrost.framework.logic.dto.*;
import java.util.UUID;

@ApplicationScoped
public class OulKafkaMapper
{

   public OulResponse toOulResponse(OperativtUppgiftslagerResponseMessage oulResponseMessage)
   {
      return ImmutableOulResponse.builder()
            .kundbehovsflodeId(UUID.fromString(oulResponseMessage.getKundbehovsflodeId()))
            .uppgiftId(UUID.fromString(oulResponseMessage.getUppgiftId()))
            .build();
   }

   public OulStatus toOulStatus(OperativtUppgiftslagerStatusMessage oulStatusMessage)
   {

      return ImmutableOulStatus.builder()
            .kundbehovsflodeId(UUID.fromString(oulStatusMessage.getKundbehovsflodeId()))
            .uppgiftId(UUID.fromString(oulStatusMessage.getUppgiftId()))
            .uppgiftStatus(mapStatus(oulStatusMessage.getStatus()))
            .build();
   }

   private UppgiftStatus mapStatus(Status status)
   {

      switch (status)
      {
         case NY:
            return UppgiftStatus.NY;
         case TILLDELAD:
            return UppgiftStatus.TILLDELAD;
         case AVSLUTAD:
         default:
            return UppgiftStatus.AVSLUTAD;
      }
   }
}
