/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Authenticator.Authenticator;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class DBAuthenticatorHandler {

    public boolean login(Authenticator auth) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Connection c = DBConnector.connect();
        try {
            PreparedStatement s = c.prepareStatement("SELECT * FROM authorized_person WHERE username=? AND password=?");
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(("admin").getBytes());
            byte[] mdbytes = md.digest();

            //convert the byte to hex format method 1
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mdbytes.length; i++) {
                sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            s.setString(1, auth.getUsername());
            s.setString(2, sb.toString());
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        } finally {
            DBConnector.closeDB(c);
        }
    }
}
