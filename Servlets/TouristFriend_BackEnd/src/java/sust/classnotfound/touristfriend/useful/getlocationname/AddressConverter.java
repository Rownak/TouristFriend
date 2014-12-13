package sust.classnotfound.touristfriend.useful.getlocationname;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 *
 * @author Abhishek Somani
 *
 */
public class AddressConverter {
    /*
     * Geocode request URL. Here see we are passing "json" it means we will get
     * the output in JSON format. You can also pass "xml" instead of "json" for
     * XML output. For XML output URL will be
     * "http://maps.googleapis.com/maps/api/geocode/xml";
     */

    private static final String URL = "http://maps.googleapis.com/maps/api/geocode/json";

    public GoogleResponse convertFromLatLong(String latlongString) throws IOException {

        /*
         * Create an java.net.URL object by passing the request URL in
         * constructor. Here you can see I am converting the fullAddress String
         * in UTF-8 format. You will get Exception if you don't convert your
         * address in UTF-8 format. Perhaps google loves UTF-8 format. :) In
         * parameter we also need to pass "sensor" parameter. sensor (required
         * parameter) — Indicates whether or not the geocoding request comes
         * from a device with a location sensor. This value must be either true
         * or false.
         */
        URL url = new URL(URL + "?latlng="
                + URLEncoder.encode(latlongString, "UTF-8") + "&sensor=false");
        // Open the Connection
        URLConnection conn = url.openConnection();

        InputStream in = conn.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        GoogleResponse response = (GoogleResponse) mapper.readValue(in, GoogleResponse.class);
        in.close();
        return response;

    }

    public ArrayList<String> getLocationNameList(double lat, double lon) throws IOException {

        String latlon = lat + "," + lon;
       // System.out.println(latlon);
        ArrayList<String> locationNameList = new ArrayList<String>();
     
        GoogleResponse res1 = new AddressConverter().convertFromLatLong(latlon);
        if (res1.getStatus().equals("OK")) {
       
            for (Result result : res1.getResults()) {
                
               // System.out.println("address is :" + result.getFormatted_address());
                
              
                locationNameList.add(result.getFormatted_address());
            }
        } else {
            //System.out.println(res1.getStatus());
        }

        return locationNameList;

    }

}
