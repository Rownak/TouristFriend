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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sust.classnotfound.touristfriend.apiImpl.UserApiImpl;
import sust.classnotfound.touristfriend.bean.UserBean;
import sust.classnotfound.touristfriend.exception.GenericBusinessException;
import sust.classnotfound.touristfriend.useful.ReadRequest;

/**
 *
 * @author Rownak
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        StringBuffer resultBuffer = new StringBuffer();
        resultBuffer = ReadRequest.converToString(request, response);
        PrintWriter out = response.getWriter();
        //------------creat userBean object from the Json Data------------------
        UserBean userBean;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println("josn created");
        userBean = gson.fromJson(resultBuffer.toString(), UserBean.class);
        System.out.println("object created");
        //------------Check if the email and password is Valid------------
        String result =check(userBean);
        out.println(result);
    }
    
    private String check(UserBean userBean) {
        
        UserApiImpl userApiImpl = new UserApiImpl();
        Boolean valid = false;
        try {
           valid= userApiImpl.loginCheck(userBean);
        } catch (GenericBusinessException ex) {
            return "invalid";
            
        }
        if(valid){
            return "Valid";
        }
        else{
            return "Invalid";
        }
        
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
