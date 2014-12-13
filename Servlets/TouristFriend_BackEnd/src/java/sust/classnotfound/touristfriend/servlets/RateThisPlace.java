/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sust.classnotfound.touristfriend.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sust.classnotfound.touristfriend.entity.Place;
import sust.classnotfound.touristfriend.entity.RatingMapping;
import sust.classnotfound.touristfriend.entity.Season;
import sust.classnotfound.touristfriend.exception.GenericBusinessException;
import sust.classnotfound.touristfriend.session.RatingMappingService;
import sust.classnotfound.touristfriend.useful.getlocationname.GetLocationFromLatLon;

/**
 *
 * @author Rownak
 */
public class RateThisPlace extends HttpServlet {


    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    double latitude;
    double rate;
    double longitude;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        System.out.println("in RatingPlace");
         String latString = request.getParameter("latitude");
        String longString = request.getParameter("longitude");
        String rateString = request.getParameter("rate");
        try{
            rate = Double.parseDouble(rateString);
            latitude = Double.parseDouble(latString);
            longitude = Double.parseDouble(longString);
        }catch(NumberFormatException e){
            out.println("Not Double Value");
            return;
        }

        
        GetLocationFromLatLon getAddress = new GetLocationFromLatLon();
        //--------------Getting Location Name-address of the given Latitude Longitude
        
        getAddress.getLocationAddress(latitude, longitude);
        Place place= getAddress.getPlace();
        //-------------We havn't work On the season , so we set default value season 1
        Season season = new Season(1);
        
        RatingMappingService ratingMappingService = new RatingMappingService();
        RatingMapping ratingMapping = new RatingMapping();
        try {
            List listOfRatingMapping= ratingMappingService.findRatingMappingByIdPlace(place.getIdPlace());
            
            if(listOfRatingMapping.size()>0){
                System.out.println("Place Found");
                ratingMapping = (RatingMapping) listOfRatingMapping.get(0);
                
            }else{
                System.out.println("Place not Found");
                ratingMapping = ratingMappingService.addRatingMapping(ratingMapping);
            }
            
            int numOfUserRated = ratingMapping.getNumOfUserRated();
                double totalRating = ratingMapping.getRating()*numOfUserRated;
                ratingMapping.setNumOfUserRated(numOfUserRated+1);
                ratingMapping.setRating(rate+totalRating/(numOfUserRated+1));
                
                ratingMappingService.saveRatingMapping(ratingMapping);
        } catch (GenericBusinessException ex) {
            Logger.getLogger(RateThisPlace.class.getName()).log(Level.SEVERE, null, ex);
        }
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
