/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sust.classnotfound.touristfriend.api;

import java.util.List;
import sust.classnotfound.touristfriend.bean.UserBean;



/**
 *
 * @author Rownak
 */
public interface UserApi {
    
   
    UserBean addUser(UserBean userBean) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

    List findUserByEmail(java.lang.String email) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    
    Boolean loginCheck(UserBean userBean) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    
    UserBean findUserByIdUser(java.lang.Integer idUser) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    void saveUser(UserBean userBean) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
}
