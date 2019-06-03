/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary.filter;

import control.Store;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author geopossachs
 */
@RequestScoped
@Provider
public class JaxRsFilter implements ContainerRequestFilter {

    Logger LOG = Logger.getLogger(this.getClass().getName());

    @Inject
    private Store store;

    @Override
    public void filter(ContainerRequestContext requestContext) {

        String cidValue = requestContext.getUriInfo().getQueryParameters().getFirst("cid");

        String stateValue = requestContext.getHeaders().getFirst("STATE");

        String storeValue = "MOCK";

        LOG.info("step before read data from ConversationScoped bean");
        // the code will work if you comment out the next line of code
        storeValue = store.getDemoData();

        if (storeValue.equals(stateValue)) {
            LOG.info("test ok");
        } else {
            LOG.info("test not ok");
        }

        LOG.info("end of ContainerRequestFilter");
    }

}
