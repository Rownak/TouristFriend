/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sust.classnotfound.touristfriend.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sust.classnotfound.touristfriend.api.UserApi;
import sust.classnotfound.touristfriend.apiImpl.UserApiImpl;
import sust.classnotfound.touristfriend.bean.UserBean;
import sust.classnotfound.touristfriend.exception.GenericBusinessException;
import sust.classnotfound.touristfriend.useful.ReadRequest;
import sust.classnotfound.touristfriend.useful.SendMail;

/**
 *
 * @author Rownak
 */
@WebServlet(name = "Registration", urlPatterns = {"/Registration"})
public class Registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        StringBuffer resultBuffer = new StringBuffer();
        resultBuffer = ReadRequest.converToString(request, response);
        
        //-----------Creating userBean Object From Json String
        UserBean userBean;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println("josn created");
        userBean = gson.fromJson(resultBuffer.toString(), UserBean.class);
        System.out.println("object created");
        
        
        //----------Creating The User
        UserApi userApi = new UserApiImpl();
        String result = "Error";
        try {
            userBean= userApi.addUser(userBean);
            //---------Sendin Verification Mail
            SendMail.sendMail(userBean.getEmail(),userBean.getIdUser());
            result = "Success";
        } catch (GenericBusinessException ex) {
            result = "Error";
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            result = "Email Not Exist";
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        out.println(result);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
