package se.fk.rimfrost.framework.oul.logic.dto;

import jakarta.annotation.Nullable;
import org.immutables.value.Value;
import se.fk.rimfrost.Status;
import java.util.UUID;

@Value.Immutable
public interface OulStatus
{
   UUID handlaggningId();

   UUID uppgiftId();

   @Nullable
   Idtyp utforarId();

   Status uppgiftStatus();

}
