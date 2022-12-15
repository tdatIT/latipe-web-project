package com.webproject.controller.user;

import com.webproject.service.IUserService;
import com.webproject.service.impl.UserServiceImpl;
import com.webproject.variable.Router;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(urlPatterns = {"/forgotPassword"})
public class ForgotPassword extends HttpServlet {
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getRequestDispatcher("/view/user/forgotPassword.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String email = req.getParameter("email");
        if (email == null) {
            req.getRequestDispatcher(Router.ERROR_404_PAGE).forward(req, response);
        }
        String pass = userService.resetPassword(email);
        if (pass == null) {
            req.getRequestDispatcher(Router.ERROR_404_PAGE).forward(req, response);
        }
        // Recipient's email ID needs to be mentioned.

        final String username = "anhn77158@gmail.com";
        final String password = "qqmmnmhwzcutosmw";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "anhn77158@gmail.com";

//        // Assuming you are sending email from localhost
//        String host = "localhost";
//
//        // Get system properties
//        Properties properties = System.getProperties();
//
//        // Setup mail server
//        properties.setProperty("mail.smtp.host", host);
//        properties.setProperty("mail.smtp.port", "8080");
//        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
//        properties.put("mail.smtp.auth", "true"); //enable authentication
//        properties.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        // Get the default Session object.
//        Authenticator auth = new Authenticator() {
//            public PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("anhn77158@gmail.com", "bevgxcvgaxlgmnja");
//            }
//        };
//        Session session = Session.getDefaultInstance(properties, auth);
//        // Set response content type
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();

        try {

            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Reset Password!");
            // Send the actual HTML message, as big as you like
            message.setContent("<h1>Your password: " + pass + "</h1>", "text/html");
            // Send message
            Transport.send(message);
            response.sendRedirect(req.getContextPath() + "/login");
        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
