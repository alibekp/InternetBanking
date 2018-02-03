/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Account;

/**
 *
 * @author user
 */
public interface AccountSessionBeanRemote {
    void addAccount(Account a);
    void removeAccount(Long id);
    Account getAccountById (Long id);
    Account getAccountByName (String name);
}
