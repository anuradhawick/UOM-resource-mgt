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
   
   public ArrayList<Resource> getCategoryWiseResources(String category,int offset,int limit){
       return new DBSearchHandler().SearchKeyword(category,offset,limit);
   }
   
   public ArrayList<Resource> getResourceByWord(String word,int offset,int limit){
       return new DBSearchHandler().searchbyWord(word,offset,limit);
   }
   
   public ArrayList<Resource> getCapacityresource(String Category,int capacity,int offset,int limit){
       return new DBSearchHandler().getCapacityResource(Category, capacity, offset, limit);
   }
}
