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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sust.classnotfound.touristfriend.bean.PlaceBean;
import sust.classnotfound.touristfriend.bean.UserBean;
import sust.classnotfound.touristfriend.entity.Place;
import sust.classnotfound.touristfriend.exception.GenericBusinessException;
import sust.classnotfound.touristfriend.session.PlaceService;
import sust.classnotfound.touristfriend.useful.ReadRequest;

/**
 *
 * @author Rownak
 */
@WebServlet(name = "MapShow", urlPatterns = {"/MapShow"})
public class MapShow extends HttpServlet {

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
        //----------------Creat PlaceBean Object from Json String--------
        PlaceBean currentPlace;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println("josn created");
        currentPlace = gson.fromJson(resultBuffer.toString(), PlaceBean.class);
        System.out.println("object created");
        
        //------------List All the Places From Database----------
        PlaceService placeService = new PlaceService();
        List<Place> listOfPlaces = new ArrayList<Place>();
        
        try {
            
            listOfPlaces = placeService.getPlaceList();
         //   System.out.println("####"+listOfPlace.get(1).getPhotosList().size());
        } catch (GenericBusinessException ex) {
            Logger.getLogger(MapShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<PlaceBean> listOfPlaceBean = new ArrayList<PlaceBean>();
        
        //-----------Take the nearest places between 50km from Current Place-----------
        for(int i=0; i< listOfPlaces.size(); i++){
            
            double currentPlaceLatitude = currentPlace.getLatitude();
            double currentPlaceLongitude = currentPlace.getLongitude();
            double anyPlaceLatitude = listOfPlaces.get(i).getLatitude();
            double anyPlaceLongitude = listOfPlaces.get(i).getLongitude();
            double distance = CalculationByDistance(currentPlaceLatitude, currentPlaceLongitude, anyPlaceLatitude,anyPlaceLongitude );
            
            if(distance<50.00){
                PlaceBean nearestPlace = new PlaceBean(listOfPlaces.get(i));
                listOfPlaceBean.add(nearestPlace);
            }
        }
        String result = gson.toJson(listOfPlaceBean);
        out.println(result);
        
    }
    
    public double CalculationByDistance(double lat1, double lon1, double lat2, double lon2) {
	        int Radius=6371;//radius of earth in Km         
	        
	        double dLat = Math.toRadians(lat2-lat1);
	        double dLon = Math.toRadians(lon2-lon1);
	        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	        Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	        Math.sin(dLon/2) * Math.sin(dLon/2);
	        double c = 2 * Math.asin(Math.sqrt(a));
	        double valueResult= Radius*c;
	        double km=valueResult/1;
	        DecimalFormat newFormat = new DecimalFormat("####");
	        int kmInDec =  Integer.valueOf(newFormat.format(km));
	        double meter=valueResult%1000;
	        int  meterInDec= Integer.valueOf(newFormat.format(meter));
	        System.out.println("Radius Value"+""+valueResult+"   KM  "+kmInDec+" Meter   "+meterInDec);

	       return Radius * c;
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
