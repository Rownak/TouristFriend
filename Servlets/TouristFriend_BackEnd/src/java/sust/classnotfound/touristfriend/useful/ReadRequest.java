/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sust.classnotfound.touristfriend.useful;

import java.io.BufferedReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rownak
 */
public class ReadRequest {
    
    public static StringBuffer converToString(HttpServletRequest request, HttpServletResponse response){
        StringBuffer resultBuffer = new StringBuffer();
        String line = null;
        System.out.println("Data Connected");

        try {
            BufferedReader reader = request.getReader();
      
            while ((line = reader.readLine()) != null) {
                resultBuffer.append(line);
            }
        } catch (Exception e) { /*
             * report an error
             */ 
            System.out.println("Json Error");
        }
        return resultBuffer;
    }
}
