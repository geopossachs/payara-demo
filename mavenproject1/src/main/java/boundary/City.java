/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author geopossachs
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class City {

    Logger LOG = Logger.getLogger(this.getClass().getName());

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public JsonObject echo(
            @FormParam("citý") String cityName,
            @FormParam("zip") String zipCode) {        
        LOG.log(Level.INFO, "cit\u00fd is {0}", cityName);
        LOG.log(Level.INFO, "zip is {0}", zipCode);

        return Json.createObjectBuilder()
                .add("cityName", cityName)
                .add("zipCode", zipCode)
                .build();
    }

}
