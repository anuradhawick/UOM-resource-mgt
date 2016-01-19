/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Anuradha
 */
public class ImageEncoder {

    public static String getImageString(InputStream img, int height, int width, String _class) {
        String theString = "";
        try {
            byte[] barr = IOUtils.toByteArray(img);
            Base64.Encoder en = Base64.getEncoder();
            theString = en.encodeToString(barr);
        } catch (IOException iOException) {
            // Do nothing
        }
        //item.write(f);

        return "<img class=\"" + _class + "\" src=\"data:image/jpeg;base64," + theString + "\" data-holder-rendered=\"true\" style=\"width: " + width + "px; height: " + height + ";\">";
    }

    public static String getImageStringRaw(InputStream img) {
        String theString = null;
        try {
            byte[] barr = IOUtils.toByteArray(img);
            Base64.Encoder en = Base64.getEncoder();
            theString = en.encodeToString(barr);
        } catch (Exception iOException) {
            System.out.println("err");
        }
        //item.write(f);

        return theString;
    }
}
