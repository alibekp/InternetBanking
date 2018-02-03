/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Account;
import Entity.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless(mappedName="clientbean")
public class ClientSessionBean implements ClientSessionBeanRemote{

    @PersistenceContext
    EntityManager em;
    
    @Override
    public void addClient(Client c) {
        em.persist(c);
        em.flush();
    }

    @Override
    public void removeClient(Long id) {
        Client c = getClientById(id);
        em.merge(c);
        em.flush();
        em.remove(c);
        em.flush();
    }

    @Override
    public Client getClientById(Long id) {
        Client c = em.find(Client.class, id);
        return c;
    }
    @Override
    public Client getClientByName (String name){
        Client c =null;
        Query q = em.createQuery("Select c from Client c where c.firstname = :fname").setParameter("fname", name);
        c=(Client) q.getSingleResult();
        return c;
    }

    @Override
    public Client getClientByLogin(String login) {
        Client c =null;
        Query q = em.createQuery("Select c from Client c where c.login= :fname").setParameter("fname", login);
        c=(Client) q.getSingleResult();
        System.out.println(c.getFirstname());
        return c;
    }

    @Override
    public void deposit(Client c, Integer deposit, String accountname) {
        List<Account> a = c.getAccount();
        Account acc=null;
        for(Account temp:a){
            if(temp.getAccountName().equals(accountname)){
                acc=temp;
            }
        }
        acc.setBalance(acc.getBalance()+deposit);
        em.merge(acc);
        
    }

    
    
    
            
}
