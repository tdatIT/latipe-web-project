package com.webproject.controller.uploads;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.webproject.upload.CloudinaryUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class UploadFile {
    private Cloudinary cloudinary = CloudinaryUtils.getCloudinary();

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
    /*public static String uploadFile(HttpServletRequest req, String partname) throws Exception {
        Part part = req.getPart(partname);
        String realPath = req.getServletContext().getRealPath("upload");
        Part path = req.getPart(partname);
        Map r = cloudinary.uploader().upload(path.getSubmittedFileName().getBytes(),
                ObjectUtils.asMap("resource_type", "auto"));

        String filename = (String) r.get("secure_url");


        System.out.println("Upload file:[" + filename + "] success");
        return filename;
    }*/
}
