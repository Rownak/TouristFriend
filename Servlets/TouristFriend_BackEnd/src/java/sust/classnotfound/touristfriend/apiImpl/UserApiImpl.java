/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sust.classnotfound.touristfriend.apiImpl;

import java.util.List;
import sust.classnotfound.touristfriend.api.UserApi;
import sust.classnotfound.touristfriend.bean.UserBean;
import sust.classnotfound.touristfriend.entity.Type;
import sust.classnotfound.touristfriend.entity.User;
import sust.classnotfound.touristfriend.exception.GenericBusinessException;
import sust.classnotfound.touristfriend.session.TypeService;
import sust.classnotfound.touristfriend.session.UserService;

/**
 *
 * @author Rownak
 */
public class UserApiImpl implements UserApi{

    UserService userService = new UserService();
    @Override
    public UserBean addUser(UserBean userBean) throws GenericBusinessException {
        
        
        
        Type t = new Type(userBean.getTypeBean());
        TypeService ts = new TypeService();
        List l = ts.findTypeByIdType(t.getIdType());
        if(l.size()>0){
            t=(Type) l.get(0);
        }
        
        User user = new User(userBean);
        user.setIdType(t);
        user = userService.addUser(user);
        userBean = new UserBean(user);
        
        return userBean;
    }
    
}
