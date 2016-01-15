/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.logic;

import data.DBPrivilegeUserHandler;
import java.sql.SQLException;
import model.foundation.AuthorizedPerson;
import model.foundation.Person;

/**
 *
 * @author RAVIDU-PC
 */
public class UserHandler {
    
    public Person getLOggedPerson(AuthorizedPerson person) throws SQLException{
        return new DBPrivilegeUserHandler().getLoggedPerson(person);
    }
    
}
