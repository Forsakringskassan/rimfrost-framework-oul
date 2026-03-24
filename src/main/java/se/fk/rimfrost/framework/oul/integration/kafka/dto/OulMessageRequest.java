package se.fk.rimfrost.framework.oul.integration.kafka.dto;

import org.immutables.value.Value;

import java.util.List;
import java.util.UUID;

@Value.Immutable
public interface OulMessageRequest
{

   UUID handlaggningId();

   List<UUID> individer();

   String regel();

   String beskrivning();

   String verksamhetslogik();

   String roll();

   String url();

   String replyToTopic();

}
