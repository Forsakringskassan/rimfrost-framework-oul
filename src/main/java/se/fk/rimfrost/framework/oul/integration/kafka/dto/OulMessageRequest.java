package se.fk.rimfrost.framework.oul.integration.kafka.dto;

import org.immutables.value.Value;
import se.fk.rimfrost.framework.oul.logic.dto.Idtyp;

import java.util.List;
import java.util.UUID;

@Value.Immutable
public interface OulMessageRequest
{

   UUID handlaggningId();

   List<Idtyp> individer();

   String regel();

   String beskrivning();

   String verksamhetslogik();

   String roll();

   String url();

   String replyToTopic();

}
