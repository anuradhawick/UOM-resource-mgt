/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import model.foundation.ResourceView;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dulaj
 */
public class DBSearchHandlerTest {
    
    public DBSearchHandlerTest() {
    }

    @Test
    public void testSearchKeyword() {
        System.out.println("SearchKeyword");
        String category = "";
        DBSearchHandler instance = new DBSearchHandler();
        List expResult = null;
        List result = instance.SearchKeyword(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearchbyCategory_String() {
        System.out.println("searchbyCategory");
        String word = "";
        DBSearchHandler instance = new DBSearchHandler();
        List<String> expResult = null;
        List<String> result = instance.searchbyCategory(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearchbyCategory_int_int() throws Exception {
        System.out.println("searchbyCategory");
        int start = 0;
        int end = 0;
        DBSearchHandler instance = new DBSearchHandler();
        ArrayList<ResourceView> expResult = null;
        ArrayList<ResourceView> result = instance.searchbyCategory(start, end);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
