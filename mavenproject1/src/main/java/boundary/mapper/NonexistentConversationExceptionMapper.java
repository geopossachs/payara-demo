/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.mapper;

import javax.enterprise.context.NonexistentConversationException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author geopossachs
 */
@Provider
public class NonexistentConversationExceptionMapper implements ExceptionMapper<NonexistentConversationException> {

    @Override
    public Response toResponse(NonexistentConversationException exception) {
        JsonObject data = Json.createObjectBuilder()
                .add("error", exception.toString())
                .build();
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(data)
                .build();
    }

}
