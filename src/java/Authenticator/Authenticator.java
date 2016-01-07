/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authenticator;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class Authenticator {

    private String username, password;

    public Authenticator(String username, String passString) {
        this.password = passString;
        this.username = username;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    

}
