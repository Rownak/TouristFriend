package com.example.mainprojecttheraptest;

import java.io.IOException;

import android.app.Activity;
import android.location.Location;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;

public class GetImageMetadataClass extends Activity {

	 double  latitude1= 23.909845;
     double  longitude1=91.835296;
     String flNm = Environment.getExternalStorageDirectory() + "/DCIM/Camera/img.jpg";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 exif2Loc(flNm);
	}
	
	public void exif2Loc(String flNm) {
		  String sLat = "", sLatR = "", sLon = "", sLonR = "";
		  try {
		    ExifInterface ef = new ExifInterface(flNm);
		    sLat  = ef.getAttribute(ExifInterface.TAG_GPS_LATITUDE);
		    sLon  = ef.getAttribute(ExifInterface.TAG_GPS_LONGITUDE);
		    sLatR = ef.getAttribute(ExifInterface.TAG_GPS_LATITUDE_REF);
		    sLonR = ef.getAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF);
		  } catch (IOException e) {}

		  double lat = dms2Dbl(sLat);
		  if (lat > 180.0) ; 
		  double lon = dms2Dbl(sLon);
		  if (lon > 180.0); 

		  lat = sLatR.contains("S") ? -lat : lat;
		  lon = sLonR.contains("W") ? -lon : lon;

		  Location loc = new Location("exif");
		  loc.setLatitude(lat);
		  loc.setLongitude(lon);
		  
		  System.out.println("###"+lat);
		  
		  
		}
		//-------------------------------------------------------------------------
		double dms2Dbl(String sDMS){
		  double dRV = 999.0;
		  try {
		    String[] DMSs = sDMS.split(",", 3);
		    String s[] = DMSs[0].split("/", 2);
		    dRV = (new Double(s[0])/new Double(s[1]));
		    s = DMSs[1].split("/", 2);
		    dRV += ((new Double(s[0])/new Double(s[1]))/60);
		    s = DMSs[2].split("/", 2);
		    dRV += ((new Double(s[0])/new Double(s[1]))/3600);
		  } catch (Exception e) {}
		  return dRV;
		}


}
