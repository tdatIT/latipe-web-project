package com.webproject.controller.vendor;

import com.webproject.controller.uploads.UploadFile;
import com.webproject.model.Store;
import com.webproject.service.IStoreService;
import com.webproject.service.impl.StoreServiceImpl;
import com.webproject.variable.SessionVar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 4,
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(urlPatterns = {"/store-admin/upload-image-store"})
public class ChangeImgController extends HttpServlet {
    private IStoreService storeService = new StoreServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            Store store = (Store) session.getAttribute(SessionVar.STORE_OBJ);
            if (req.getPart("avatar") != null) {
                store.setAvatar(UploadFile.uploadFile(req, "avatar"));
            }
            if (req.getPart("cover") != null) {
                store.setCover(UploadFile.uploadFile(req, "cover"));
            }
            storeService.updateStore(store);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
