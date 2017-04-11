/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.roles;

import designpatterns.structure.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class PrototypeRole extends Type{

    private List<Client> clients;
    
    public PrototypeRole(String completeName) {
        super(completeName);
        this.clients = new ArrayList<>();
    }
    
    public List<Client> getClients(){
        return this.clients;
    }
    
    public void addClient(Client client){
        this.clients.add(client);
    }
    
    public Client lastClient(){
        int size = this.clients.size();
        return this.clients.get(size - 1);
    }

    @Override
    public String toString() {
        return "Prototype";
    }
    
}
