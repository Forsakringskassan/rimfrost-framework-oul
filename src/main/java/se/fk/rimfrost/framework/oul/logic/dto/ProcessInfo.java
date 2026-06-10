package se.fk.rimfrost.framework.oul.logic.dto;

import org.immutables.value.Value;

import java.util.Map;

@Value.Immutable
public interface ProcessInfo
{
   Map<String, String> cloudeventAttributes();

   String replyTopic();
}
