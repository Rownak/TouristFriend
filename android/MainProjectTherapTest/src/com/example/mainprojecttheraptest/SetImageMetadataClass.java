package com.example.mainprojecttheraptest;

import java.io.IOException;

import android.media.ExifInterface;
import android.os.Environment;

public class SetImageMetadataClass {

//	 double  latitude1= 23.909845;
//     double  longitude1=91.835296;
//     String flNm = Environment.getExternalStorageDirectory() + "/DCIM/Camera/img.jpg";
     
     double  latitude1;
     double  longitude1;
     String flNm;
     
     
     
    public double getLatitude1() {
		return latitude1;
	}

	public void setLatitude1(double latitude1) {
		this.latitude1 = latitude1;
	}

	public double getLongitude1() {
		return longitude1;
	}

	public void setLongitude1(double longitude1) {
		this.longitude1 = longitude1;
	}

	public String getFlNm() {
		return flNm;
	}

	public void setFlNm(String flNm) {
		this.flNm = flNm;
	}

	public SetImageMetadataClass(String imageName, Double lat, Double lang) {
		// TODO Auto-generated constructor stub
    	flNm=Environment.getExternalStorageDirectory()+imageName;
    	latitude1=lat;
    	longitude1=lang;
    	
    	
    	
    	
	}
	
     public void loc2Exif(String flNm,double latitude,double longitude) {
   	  try {
   	    ExifInterface ef = new ExifInterface(flNm);
   	    ef.setAttribute(ExifInterface.TAG_GPS_LATITUDE, dec2DMS(latitude));
   	    ef.setAttribute(ExifInterface.TAG_GPS_LONGITUDE,dec2DMS(longitude));
   	    if (latitude > 0) 
   	      ef.setAttribute(ExifInterface.TAG_GPS_LATITUDE_REF, "N"); 
   	    else              
   	      ef.setAttribute(ExifInterface.TAG_GPS_LATITUDE_REF, "S");
   	    if (longitude>0) 
   	      ef.setAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF, "E");    
   	     else             
   	       ef.setAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF, "W");
   	    ef.saveAttributes();
   	  } catch (IOException e) {}         
   	}
   
   	String dec2DMS(double coord) {  
   	  coord = coord > 0 ? coord : -coord;  // -105.9876543 -> 105.9876543
   	  String sOut = Integer.toString((int)coord) + "/1,";   // 105/1,
   	  coord = (coord % 1) * 60;         // .987654321 * 60 = 59.259258
   	  sOut = sOut + Integer.toString((int)coord) + "/1,";   // 105/1,59/1,
   	  coord = (coord % 1) * 60000;             // .259258 * 60000 = 15555
   	  sOut = sOut + Integer.toString((int)coord) + "/1000";   // 105/1,59/1,15555/1000
   	  return sOut;
   	}
     
}
