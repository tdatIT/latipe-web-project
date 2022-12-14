package com.webproject.upload;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryUtils {
    public static Cloudinary getCloudinary() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dddb8btv0",
                "api_key", "159138865977743",
                "api_secret", "xz-CUQykgKnBja571VNtfhX2gsU",
                "secure", true
        ));
        return cloudinary;
    }
}
