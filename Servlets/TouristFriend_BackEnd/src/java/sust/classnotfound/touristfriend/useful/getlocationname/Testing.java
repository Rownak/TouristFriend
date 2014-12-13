/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.classnotfound.touristfriend.useful.getlocationname;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sust.classnotfound.touristfriend.entity.District;
import sust.classnotfound.touristfriend.entity.Location;
import sust.classnotfound.touristfriend.entity.Place;
import sust.classnotfound.touristfriend.exception.GenericBusinessException;
import sust.classnotfound.touristfriend.session.DistrictService;

/**
 *
 * @author Rownak
 */
public class Testing {

    public static void main(String[] args) {
//        double[][] latlan = {{24.912,91.8322},{23.7315,90.3925},{23.7495747,90.3967635},{23.8583,90.2667},
//            {25.1633829,92.0175242},{25.17064,91.885786}};
        
        GetLocationFromLatLon gl = new GetLocationFromLatLon();
        gl.getLocationAddress(24.912, 91.8322);
        System.out.println(gl.getPlace().getName());
    }
        
}
