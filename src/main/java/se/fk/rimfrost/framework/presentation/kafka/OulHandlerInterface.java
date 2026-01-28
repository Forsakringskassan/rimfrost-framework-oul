package se.fk.rimfrost.framework.presentation.kafka;

import se.fk.rimfrost.framework.logic.dto.OulResponse;
import se.fk.rimfrost.framework.logic.dto.OulStatus;

public interface OulHandlerInterface
{
   void handleOulResponse(OulResponse oulResponse);

   void handleOulStatus(OulStatus oulStatus);
}
