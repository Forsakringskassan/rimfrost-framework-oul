package se.fk.rimfrost.framework.integration.kafka.dto;

import org.immutables.value.Value;
import java.util.UUID;

@Value.Immutable
public interface OulMessageRequest
{

   UUID kundbehovsflodeId();

   String kundbehov();

   String regel();

   String beskrivning();

   String verksamhetslogik();

   String roll();

   String url();

}
