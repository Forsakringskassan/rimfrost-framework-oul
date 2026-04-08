package se.fk.rimfrost.framework.oul.integration.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.Idtyp;
import se.fk.rimfrost.OperativtUppgiftslagerRequestMessage;
import se.fk.rimfrost.framework.oul.integration.kafka.dto.OulMessageRequest;

import java.util.UUID;

@ApplicationScoped
public class OulKafkaMapper
{

   public OperativtUppgiftslagerRequestMessage toOulRequestMessage(OulMessageRequest messageRequest)
   {
      var request = new OperativtUppgiftslagerRequestMessage();
      request.setVersion("1.0");
      request.setHandlaggningId(messageRequest.handlaggningId().toString());
      request.setIndivider(messageRequest.individer().stream().map(this::toApiIdtyp).toArray(Idtyp[]::new));
      request.setRegel(messageRequest.regel());
      request.setRoll(messageRequest.roll());
      request.setBeskrivning(messageRequest.beskrivning());
      request.setVerksamhetslogik(messageRequest.verksamhetslogik());
      request.setUrl(messageRequest.url());
      return request;
   }

   private Idtyp toApiIdtyp(se.fk.rimfrost.framework.oul.logic.dto.Idtyp idtyp)
   {
      Idtyp apiIdtyp = new Idtyp();
      apiIdtyp.setTypid(idtyp.typId());
      apiIdtyp.setVarde(idtyp.varde());

      return apiIdtyp;
   }
}
