/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;

/**
 *
 * @author Georg
 */
@ConversationScoped
public class Store implements Serializable {

    Logger LOG = Logger.getLogger(this.getClass().getName());

    private String demoData;

    @PostConstruct
    private void init() {
        this.demoData = UUID.randomUUID().toString();

        LOG.log(Level.INFO, "init store with {0}", demoData);
    }

    public String getDemoData() {
        return demoData;
    }

    public void setDemoData(String demoData) {
        this.demoData = demoData;
    }

}
