/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.classnotfound.touristfriend.servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import sust.classnotfound.touristfriend.entity.Photos;
import sust.classnotfound.touristfriend.entity.Place;
import sust.classnotfound.touristfriend.entity.Season;
import sust.classnotfound.touristfriend.entity.User;
import sust.classnotfound.touristfriend.exception.GenericBusinessException;
import sust.classnotfound.touristfriend.session.PhotosService;
import sust.classnotfound.touristfriend.session.SeasonService;
import sust.classnotfound.touristfriend.session.UserService;
import sust.classnotfound.touristfriend.useful.getlocationname.GetLocationFromLatLon;

/**
 *
 * @author Rownak
 */
public class UploadImage extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String imageDataString;
    String imageName;
    double latitude;
    double langitude;
    String path;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String latString = request.getParameter("latitude");
        String longString = request.getParameter("longitude");

        latitude = Double.parseDouble(latString);
        langitude = Double.parseDouble(longString);
        //---------------Get Current Location name-Address from Latitude-Longitude
        GetLocationFromLatLon getAddress = new GetLocationFromLatLon();
        getAddress.getLocationAddress(latitude, langitude);
        Place place = getAddress.getPlace();
        if (getAddress.isDistrictFound()) {

            imageDataString = request.getParameter("image");
            imageName = request.getParameter("image_name");
            path = "pictures\\" + getAddress.getDistrict().getDistrictName() + "\\" + getAddress.getLocation().getLocationName();
            String imageUrl = "/" + getAddress.getDistrict().getDistrictName() + "/" + getAddress.getLocation().getLocationName() + "/" + imageName;
            try {
                //System.out.println("#####################dhukse############");
                insertImageToDatabase(place, imageUrl, "1", "1");
            } catch (GenericBusinessException ex) {
                Logger.getLogger(UploadImage.class.getName()).log(Level.SEVERE, null, ex);
            }
            uploadImageToFolder(path);
            response.getWriter().println("Done");
        } else {
            response.getWriter().println("Location not found");
        }

    }

    private void insertImageToDatabase(Place place, String imageUrl, String idUser, String idSeason) throws GenericBusinessException {

        PhotosService photosService = new PhotosService();
        UserService userService = new UserService();
        SeasonService seasonService = new SeasonService();
        User user = (User) userService.findUserByIdUser(Integer.parseInt(idUser)).get(0);
        Season season = (Season) seasonService.findSeasonByIdSeason(Integer.parseInt(idSeason)).get(0);
        Photos photos = new Photos(0, latitude, langitude, imageUrl, user, place, season);

        photosService.addPhotos(photos);
    }

    private void uploadImageToFolder(String path) throws FileNotFoundException, IOException {

        byte[] imageByteArray = decodeImage(imageDataString);
//C:\\xampp\\tomcat\\webapps\\ROOT\\Newfolder
//		File imageDirectory = new File("C:\\Program Files\\Apache Software Foundation\\Apache Tomcat 7.0.22\\webapps\\ROOT"
//				+ File.separator + "profile_images");
        File imageDirectory = new File(getServletContext().getRealPath("")
                + File.separator + path);

        if (!imageDirectory.exists()) {
            imageDirectory.mkdir();
        }

        FileOutputStream fOut = new FileOutputStream(imageDirectory
                + File.separator + imageName);
        fOut.write(imageByteArray);

        System.out.println(getServletContext());

    }

    public static byte[] decodeImage(String imageDataString) {
        return Base64.decodeBase64(imageDataString);
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
        doGet(request, response);
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
