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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sust.classnotfound.touristfriend.bean.PlaceBean;
import sust.classnotfound.touristfriend.entity.Place;
import sust.classnotfound.touristfriend.exception.GenericBusinessException;
import sust.classnotfound.touristfriend.session.PlaceService;
import sust.classnotfound.touristfriend.useful.ReadRequest;

/**
 *
 * @author Rownak
 */
@WebServlet(name = "PhotosGet", urlPatterns = {"/PhotosGet"})
public class PhotosGet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
                StringBuffer resultBuffer = new StringBuffer();
        resultBuffer = ReadRequest.converToString(request, response);
        PrintWriter out = response.getWriter();
        
        PlaceBean placeBean;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println("josn created");
        placeBean = gson.fromJson(resultBuffer.toString(), PlaceBean.class);
        System.out.println("object created");
        
        System.out.println(placeBean.getName());
        System.out.println(placeBean.getLatitude());
        
        
        PlaceService placeService = new PlaceService();
        
        try {
            Place p = null;
            List list = placeService.findPlaceByIdPlace(placeBean.getIdPlace());
            if(list.size()>0){
                 p = (Place) list.get(0);
            System.out.println(p.getPhotosList().get(0).getDescription());
            }
            else{
                System.out.println("nothing");
                System.out.println(p.getName());
            }
        } catch (GenericBusinessException ex) {
            Logger.getLogger(PhotosGet.class.getName()).log(Level.SEVERE, null, ex);
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
