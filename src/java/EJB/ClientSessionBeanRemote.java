/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Client;
import javax.ejb.Remote;

/**
 *
 * @author user
 */
@Remote
public interface ClientSessionBeanRemote {
    
    void addClient(Client c);
    void removeClient(Long id);
    Client getClientById(Long id);
    Client getClientByName (String name);
    Client getClientByLogin (String login);
    void deposit (Client c, Integer deposit, String accountname);
}
