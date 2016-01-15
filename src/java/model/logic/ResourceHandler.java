/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.logic;

import data.*;
import java.sql.SQLException;
import java.util.ArrayList;
import model.foundation.*;

/**
 *
 * @author RAVIDU-PC
 */
public class ResourceHandler {

    public int getResourceCount() throws SQLException {
        return new DBSelectHandler().getResourceCount();
    }

    public ArrayList<ResourceView> getResources(int start, int end) throws SQLException {
        return new DBSearchHandler().searchbyCategory(start, end);
    }
    
   public Resource getResource(String category,int id){
       return new DBSearchHandler().SearchResource(category, id);
   }
   
   public ArrayList<Resource> getCategoryWiseResources(String category){
       return new DBSearchHandler().SearchKeyword(category);
   }
}
