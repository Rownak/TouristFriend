/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sust.classnotfound.touristfriend.api;

import sust.classnotfound.touristfriend.bean.UserBean;



/**
 *
 * @author Rownak
 */
public interface UserApi {
    
    UserBean addUser(UserBean userBean) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

    
}
