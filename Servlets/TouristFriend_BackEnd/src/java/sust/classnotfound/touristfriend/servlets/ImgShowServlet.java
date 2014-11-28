package sust.classnotfound.touristfriend.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sust.classnotfound.touristfriend.bean.PhotosBean;
import sust.classnotfound.touristfriend.bean.PlaceBean;
import sust.classnotfound.touristfriend.entity.Place;
import sust.classnotfound.touristfriend.session.PlaceService;
import sust.classnotfound.touristfriend.useful.ReadRequest;
/**
 *
 * @author Rownak
 */
@WebServlet(urlPatterns = {"/ImgShowServlet"})
public class ImgShowServlet extends HttpServlet {

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
        String address = request.getParameter("address");
        System.out.println(address);
        
         StringBuffer resultBuffer = new StringBuffer();
        resultBuffer = ReadRequest.converToString(request, response);
        PrintWriter out1 = response.getWriter();
        
        PlaceBean placeBean;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println("josn created");
        
        PhotosBean photosBean = new PhotosBean();

			Type type = new TypeToken<List<PhotosBean>>() {
			}.getType();

		List<PhotosBean> listOfPhotosBean = gson.fromJson(address, type);
        
        
        
        System.out.println("object created");
        
       
        
        
        PlaceService placeService = new PlaceService();
        List<Place> listOfPlace = new ArrayList<Place>();
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            //out.println("<title>Servlet ImgShowServlet</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.println("<h1>Servlet ImgShowServlet at " + getServletContext().getRealPath("")+ File.separator + "profile_images" + "</h1>");

            // System.out.println(str);
            //String[] addressArray = {"c/c.jpg", "a/a.jpg", "b/b.jpg"};
            for (int i = 0; i < listOfPhotosBean.size(); i++) {
                String str = "http://192.168.2.110:8084/ImageUpload1/" + listOfPhotosBean.get(i).getPhotoUrl();
                out.println("<img src=" + "\"" + str + "\"" + "/>");
            }

            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);

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
