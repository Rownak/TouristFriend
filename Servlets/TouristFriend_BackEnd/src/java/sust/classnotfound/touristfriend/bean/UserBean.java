/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sust.classnotfound.touristfriend.bean;

import java.util.Date;
import sust.classnotfound.touristfriend.entity.User;

/**
 *
 * @author Rownak
 */
public class UserBean {
    
    private Integer idUser;
    
    private int userId;
    
    private String userName;
    
    private String email;
    
    private String address;
    
    private boolean validity;
    
    private String sex;
    private Date dob;
    
    
    private TypeBean typeBean;

    public UserBean(User user) {
        this.idUser = user.getIdUser();
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.validity = user.getValidity();
        this.sex = user.getSex();
        this.typeBean = new TypeBean(user.getIdType());
    }

    public UserBean(int userId, String userName, String email, String address, String sex) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.sex = sex;
        
    }
    
    public UserBean(Integer idUser, int userId, String userName, String email, String address, boolean validity, String sex) {
        this.idUser = idUser;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.validity = validity;
        this.sex = sex;
    }

    
    
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isValidity() {
        return validity;
    }

    public void setValidity(boolean validity) {
        this.validity = validity;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    public TypeBean getTypeBean() {
        return typeBean;
    }

    public void setTypeBean(TypeBean typeBean) {
        this.typeBean = typeBean;
    }
    
    
}
