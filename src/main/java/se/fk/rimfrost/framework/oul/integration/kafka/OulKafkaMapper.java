package se.fk.rimfrost.framework.oul.integration.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.OperativtUppgiftslagerRequestMessage;
import se.fk.rimfrost.framework.oul.integration.kafka.dto.OulMessageRequest;

@ApplicationScoped
public class OulKafkaMapper
{

   public OperativtUppgiftslagerRequestMessage toOulRequestMessage(OulMessageRequest messageRequest)
   {
      var request = new OperativtUppgiftslagerRequestMessage();
      request.setVersion("1.0");
      request.setHandlaggningId(messageRequest.handlaggningId().toString());
      request.setYrkande(messageRequest.yrkande());
      request.setRegel(messageRequest.regel());
      request.setRoll(messageRequest.roll());
      request.setBeskrivning(messageRequest.beskrivning());
      request.setVerksamhetslogik(messageRequest.verksamhetslogik());
      request.setUrl(messageRequest.url());
      return request;
   }
}
