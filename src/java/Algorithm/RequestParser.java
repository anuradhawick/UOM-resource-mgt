/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithm;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Anuradha
 */
public class RequestParser {

    public static InputStream getStream(HttpServletRequest request) throws FileUploadException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem item : multiparts) {
                if (!item.isFormField()) {
                    InputStream img = item.getInputStream();
                    return img;
                }
            }
        }
        return null;
    }
}
