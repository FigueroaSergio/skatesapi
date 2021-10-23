/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3.reto3.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author figue
 */
@Entity
@Table(name = "message")
public class Mensaje implements Serializable {
	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idMessage;
	    private String messageText;
	    
	    @ManyToOne
	    @JoinColumn(name="id")
	    @JsonIgnoreProperties({"messages", "client", "reservations"})
	    private Skate skate;
	
	    @ManyToOne
	    @JoinColumn(name="clientId")
	    @JsonIgnoreProperties({"messages", "reservations", "client"})
	    private Cliente client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Skate getSkate() {
        return skate;
    }

    public void setSkate(Skate skate) {
        this.skate = skate;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
            
}
