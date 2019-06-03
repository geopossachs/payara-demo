/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import control.Store;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author geopossachs
 */
@RequestScoped
@Path("wall")
@Produces(MediaType.APPLICATION_JSON)
public class TownWall {

    @Inject
    private Conversation con;

    @Inject
    private Store store;

    @POST
    public JsonObject getGateNumber() {
        con.begin();
        return Json.createObjectBuilder()
                .add("gate", con.getId())
                .add("stage", store.getDemoData())
                .build();
    }

}
