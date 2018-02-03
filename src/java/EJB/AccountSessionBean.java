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

@Stateless (mappedName = "accountbean")
public class AccountSessionBean implements AccountSessionBeanRemote{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void addAccount(Account a) {
        em.persist(a);
        em.flush();
    }

    @Override
    public void removeAccount(Long id) {
        Account a = getAccountById(id);
        em.merge(a);
        em.flush();
        em.remove(a);
        em.flush();
    }

    @Override
    public Account getAccountById(Long id) {
     Account a = em.find(Account.class, id);
     Integer bal=a.getBalance()+100; //DEPOSIT
     a.setBalance(bal);              //DEPOSIT
     em.merge(a);                    //DEPOSIT
     em.flush();                     //DEPOSIT
        return a;
    }

    @Override
    public Account getAccountByName(String name) {
        Account a = null;
        Query q = em.createQuery("Select c from Account c where accountName= :fname").setParameter("fname", name);
        a=(Account) q.getSingleResult();
        return a;
    }
    
    
}
