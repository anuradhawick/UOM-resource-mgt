/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.foundation.Resource;

/**
 *
 * @author Anuradha
 */
public class DBResourceImageHandler {

    private Connection connection;
    private PreparedStatement statement;

    public InputStream getImagebyRes(int res) throws SQLException {
        connection = DBConnector.connect();
        statement = connection.prepareStatement("SELECT img FROM resource_management.resource_img i WHERE i.resource_resourceid=?");
        statement.setInt(1, res);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            InputStream d = resultSet.getBinaryStream("img");
            return d;
        }

        return null;
    }

    public void addImage(int id, InputStream img) throws SQLException {
        if (img == null) {
            return;
        }
        connection = DBConnector.connect();
        statement = connection.prepareStatement("INSERT INTO resource_img (img,resourceid) VALUES(?,?)");
        statement.setBinaryStream(1, img);
        statement.setInt(2, id);
        statement.executeQuery();
        statement.close();
    }

    public void updateImage(int id, InputStream img) throws SQLException {
        if (img == null) {
            return;
        }
        connection = DBConnector.connect();
        statement = connection.prepareStatement("SELECT * FROM resource_management.resource_img WHERE resourceid=?");
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        if (set.next()) {
            statement = connection.prepareStatement("UPDATE resource_management.resource_img SET img=? WHERE resourceid=?");
            statement.setBinaryStream(1, img);
            statement.setInt(2, id);
            statement.executeUpdate();
        } else {
            statement = connection.prepareStatement("INSERT INTO resource_management.resource_img (resourceid,img) VALUES(?,?)");
            statement.setBinaryStream(2, img);
//            statement.setBinaryStream(3, p.getImage());
            statement.setInt(1, id);
            statement.execute();
        }
    }
}
