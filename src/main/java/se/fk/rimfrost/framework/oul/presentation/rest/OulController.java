package se.fk.rimfrost.framework.oul.presentation.rest;

import java.util.UUID;

import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import se.fk.rimfrost.framework.oul.jaxrsspec.controllers.generatedsource.OulDoneControllerApi;

@SuppressWarnings("unused")
public class OulController implements OulDoneControllerApi
{
   @Inject
   Instance<OulUppgiftDoneHandler> oulUppgiftDoneHandler;

   @POST
   @Path("/{kundbehovsflodeId}/done")
   @Override
   public void markDone(
         @PathParam("kundbehovsflodeId") UUID kundbehovsflodeId)
   {
      oulUppgiftDoneHandler.get().handleUppgiftDone(kundbehovsflodeId);
   }
}
