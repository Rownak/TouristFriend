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
import sust.classnotfound.touristfriend.entity.Location;
import sust.classnotfound.touristfriend.entity.District;
import sust.classnotfound.touristfriend.entity.Place;
import sust.classnotfound.touristfriend.exception.GenericBusinessException;
import sust.classnotfound.touristfriend.session.DistrictService;
import sust.classnotfound.touristfriend.session.LocationService;
import sust.classnotfound.touristfriend.session.PlaceService;

/**
 *
 * @author Rownak
 */
public class GetLocationFromLatLon {
    


    private boolean latlonMatched = false;
    private District district;
    private Location location;
    private Place place;
    private boolean districtFound = false;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
    
    public GetLocationFromLatLon(){
        district = new District();
        location = new Location();
        place = new Place();
    }
    public boolean isDistrictFound() {
        return districtFound;
    }

    public void setDistrictFound(boolean districtFound) {
        this.districtFound = districtFound;
    }

    public void setLatlonMatched(boolean latlonMatched) {
        this.latlonMatched = latlonMatched;
    }

    public boolean isLatlonMatched() {
        return latlonMatched;
    }

    public void getLocationAddress(double latitude, double longitude) {
        AddressConverter addressConverter = new AddressConverter();
        ArrayList<String> listOfLocationFromLatLon = null;
        try {
            listOfLocationFromLatLon = new ArrayList<String>();

            listOfLocationFromLatLon = addressConverter.getLocationNameList(latitude, longitude);
            setLatlonMatched(true);

        } catch (IOException ex) {
            setLatlonMatched(false);
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> locationFromLatLon = new ArrayList<String>();
        ArrayList<String> districtFromLatLon = new ArrayList<String>();
        // System.out.println("size: " +listLoc.size());
        for (int i = 0; i < listOfLocationFromLatLon.size(); i++) {
            if (i <= 2) {
                String[] splitedLoc = listOfLocationFromLatLon.get(i).split(",");
                //System.out.println("Loc Name :---------------- ");
                for (String names : splitedLoc) {
                    locationFromLatLon.add(names.trim());
                    // System.out.println(names.trim());
                }

            } else {
                String[] splitedLoc = listOfLocationFromLatLon.get(i).split(",");
                //System.out.println("District Name :---------------- ");
                for (String names : splitedLoc) {
                    districtFromLatLon.add(names.trim());
                    //System.out.println(names.trim());
                }

            }
        }

        DistrictService districtService = new DistrictService();
        
        List<District> listOfDistricts = new ArrayList<District>();
        for (int i = 0; i < districtFromLatLon.size(); i++) {
            try {
                listOfDistricts = districtService.findDistrictByDistrictName(districtFromLatLon.get(i));
                if (listOfDistricts.size() > 0) {
                    district = listOfDistricts.get(0);
                    System.out.println("District found: " + district.getDistrictName());
                    setDistrictFound(true);
                }
            } catch (GenericBusinessException ex) {
                setDistrictFound(false);
                Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (isDistrictFound()) {
            

            List<Location> listOfLocation = new ArrayList<Location>();

            listOfLocation = district.getLocationList();

            for (int i = 0; i < locationFromLatLon.size(); i++) {
                for (int j = 0; j < listOfLocation.size(); j++) {
                    if (locationFromLatLon.get(i).equalsIgnoreCase(listOfLocation.get(j).getLocationName())) {
                        System.out.println("location found: " + locationFromLatLon.get(i));
                        location = listOfLocation.get(j);
                        break;
                    }
                }
            }
            //location not found
            if (location.getIdLocation() == null) {
                
                
                LocationService locationService = new LocationService();
                Location newLocation = new Location();
                newLocation.setLatitude(latitude);
                newLocation.setLongitude(longitude);
                newLocation.setIdDistrict(district);
                newLocation.setLocationName(locationFromLatLon.get(0));
                
                try {
                    location= locationService.addLocation(newLocation);
                } catch (GenericBusinessException ex) {
                    Logger.getLogger(GetLocationFromLatLon.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            List<Place> listOfPlace = new ArrayList<Place>();
            listOfPlace = location.getPlaceList();
                
            for (int i = 0; i < listOfPlace.size(); i++) {
                    if (listOfPlace.get(i).getName().equalsIgnoreCase(locationFromLatLon.get(0))) {
                        System.out.println("Place found :" + locationFromLatLon.get(0));
                        place = listOfPlace.get(i);
                        
                    }
            }
            if(place.getIdPlace()!=null){
                    
            }
            else{
                try {
                    PlaceService placeService = new PlaceService();
                    Place newPlace = new Place();
                    newPlace.setIdLocation(location);
                    newPlace.setLatitude(latitude);
                    newPlace.setLongitude(longitude);
                    newPlace.setName(locationFromLatLon.get(0));
                    
                     place =placeService.addPlace(newPlace);
                } catch (GenericBusinessException ex) {
                    Logger.getLogger(GetLocationFromLatLon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
