package se.fk.rimfrost.framework.oul.presentation.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.fk.rimfrost.OperativtUppgiftslagerStatusMessage;

@SuppressWarnings("unused")
public class OulStatusNotificationDeserializer extends ObjectMapperDeserializer<OperativtUppgiftslagerStatusMessage>
{
   public OulStatusNotificationDeserializer()
   {
      super(OperativtUppgiftslagerStatusMessage.class);
   }
}
