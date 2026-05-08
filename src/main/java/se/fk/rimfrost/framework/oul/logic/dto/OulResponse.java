package se.fk.rimfrost.framework.oul.logic.dto;

import java.util.Map;
import java.util.UUID;
import org.immutables.value.Value;

@Value.Immutable
public interface OulResponse
{

   UUID handlaggningId();

   UUID uppgiftId();

   Map<String, String> cloudeventAttributes();

}
