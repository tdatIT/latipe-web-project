package com.webproject.controller.uploads;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UploadFile {
    public static String uploadFile(HttpServletRequest req, String partname) throws Exception {
        Part part = req.getPart(partname);
        String realPath = req.getServletContext().getRealPath("upload");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        if (!Files.exists(Paths.get(realPath))) {
            Files.createDirectory(Paths.get(realPath));
        }
        part.write(realPath + "/" + filename);
        System.out.println("Upload file:[" + filename + "] success");
        return filename;
    }
}
