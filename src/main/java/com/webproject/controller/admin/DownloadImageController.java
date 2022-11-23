package com.webproject.controller.admin;


import com.sun.corba.se.impl.orbutil.closure.Constant;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/image") // ?fname=abc.png
public class DownloadImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DownloadImageController() {
		super();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = req.getParameter("fname");
		File file = new File( "/" + fileName);
		resp.setContentType("image/jpeg");
		if (file.exists()) {
			IOUtils.copy(new FileInputStream(file), resp.getOutputStream());
		}
	}
}
