package se.fk.rimfrost.framework.oul.logic.dto;

import org.immutables.value.Value;
import java.util.UUID;

@Value.Immutable
public interface OulResponse
{

   UUID kundbehovsflodeId();

   UUID uppgiftId();

}
