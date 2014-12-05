package com.example.mainprojecttheraptest;



import java.util.Date;


/**
 *
 * @author Rownak
 */
public class UserBean {
    
private Integer idUser;
    
    private int userId;
    
    private String userName;
    
    private String email;
    
    private String password;
    
    private boolean validity;
    
    private String sex;
    private Date dob;
    
    
    private TypeBean typeBean;

    
    public UserBean(String email, String password) {
        this.userId = 0;
        this.userName = null;
        this.email = email;
        this.password = password;
        this.sex = null;
        
    }
    
    public UserBean(int userId, String userName, String email, String password, String sex) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.sex = sex;
        
    }
    
    public UserBean(Integer idUser, int userId, String userName, String email, String password, boolean validity, String sex) {
        this.idUser = idUser;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String address) {
        this.password = address;
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
