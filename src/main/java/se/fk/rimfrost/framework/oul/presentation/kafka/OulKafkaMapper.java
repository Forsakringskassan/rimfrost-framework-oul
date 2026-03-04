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
            .utforarId(UUID.fromString(oulStatusMessage.getUtforarId()))
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
