package se.fk.rimfrost.framework.oul.logic.dto;

import jakarta.annotation.Nullable;
import org.immutables.value.Value;
import java.util.Map;
import java.util.UUID;

@Value.Immutable
public interface OulStatus
{
   UUID handlaggningId();

   UUID uppgiftId();

   @Nullable
   Idtyp utforarId();

   UppgiftStatus uppgiftStatus();

   Map<String, String> cloudeventAttributes();

}
