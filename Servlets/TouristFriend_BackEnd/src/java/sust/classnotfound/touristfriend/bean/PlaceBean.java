/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.classnotfound.touristfriend.bean;

import java.util.ArrayList;
import java.util.List;
import sust.classnotfound.touristfriend.entity.Photos;
import sust.classnotfound.touristfriend.entity.Place;

/**
 *
 * @author Rownak
 */
public class PlaceBean {

    private Integer idPlace;

    private String name;

    private String description;

    private double latitude;

    private double longitude;

    private List<PhotosBean> photosBeanList;

    public List<PhotosBean> getPhotosList() {
        return photosBeanList;
    }

    public void setPhotosList(List<PhotosBean> photosList) {
        this.photosBeanList = photosList;
    }

    public PlaceBean(Place place) {
        this.idPlace = place.getIdPlace();
        this.name = place.getName();
        this.description = place.getDescription();
        this.latitude = place.getLatitude();
        this.longitude = place.getLongitude();
        System.out.println(name);
        if (place.getPhotosList().size() > 0) {
            this.photosBeanList = new ArrayList<PhotosBean>();
            for (int i = 0; i < place.getPhotosList().size(); i++) {
                PhotosBean pb = new PhotosBean(place.getPhotosList().get(i));
                this.photosBeanList.add(pb);
            }
        }

    }

    public PlaceBean(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = null;
        this.idPlace = 0;
    }

    public Integer getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Integer idPlace) {
        this.idPlace = idPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
