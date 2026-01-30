package se.fk.rimfrost.framework.oul.presentation.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.fk.rimfrost.OperativtUppgiftslagerResponseMessage;

public class OulResponseDeserializer extends ObjectMapperDeserializer<OperativtUppgiftslagerResponseMessage>
{
   public OulResponseDeserializer()
   {
      super(OperativtUppgiftslagerResponseMessage.class);
   }
}
