package se.fk.rimfrost.framework.oul.presentation.kafka;

import se.fk.rimfrost.framework.oul.logic.dto.OulResponse;
import se.fk.rimfrost.framework.oul.logic.dto.OulStatus;

public interface OulHandlerInterface
{
   void handleOulResponse(OulResponse oulResponse);

   void handleOulStatus(OulStatus oulStatus);
}
