/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.logic;

import data.DBSelectHandler;
import java.sql.SQLException;

/**
 *
 * @author RAVIDU-PC
 */
public class ResourceHandler {

    public int getResourceCount() throws SQLException {
      
            return new DBSelectHandler().getResourceCount();
       
    }
}
