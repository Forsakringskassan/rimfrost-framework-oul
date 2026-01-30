package se.fk.rimfrost.framework.oul.logic.dto;

import org.immutables.value.Value;
import java.util.UUID;

@Value.Immutable
public interface OulStatus
{
   UUID kundbehovsflodeId();

   UUID uppgiftId();

   UUID utforarId();

   UppgiftStatus uppgiftStatus();

}
