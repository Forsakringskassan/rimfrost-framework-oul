package se.fk.rimfrost.framework.oul.presentation.kafka;

import org.junit.jupiter.api.Test;
import se.fk.rimfrost.OperativtUppgiftslagerResponseMessage;
import java.util.Map;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

class OulKafkaMapperTest
{
   private final OulKafkaMapper mapper = new OulKafkaMapper();

   @Test
   void toOulResponse_mapsCloudeventAttributes()
   {
      var message = new OperativtUppgiftslagerResponseMessage();
      message.setHandlaggningId(UUID.randomUUID().toString());
      message.setUppgiftId(UUID.randomUUID().toString());
      message.setCloudeventAttributes(Map.of("source", "/oul", "type", "se.fk.uppgift.skapad"));

      var result = mapper.toOulResponse(message);

      assertThat(result.cloudeventAttributes())
            .containsEntry("source", "/oul")
            .containsEntry("type", "se.fk.uppgift.skapad");
   }
}
