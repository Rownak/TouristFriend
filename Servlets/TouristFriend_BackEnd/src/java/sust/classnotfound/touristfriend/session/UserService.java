package sust.classnotfound.touristfriend.session;

import java.util.*;
import sust.classnotfound.touristfriend.*;
import sust.classnotfound.touristfriend.servicelocator.LocatableService;
import com.finalist.util.log.*;
import sust.classnotfound.touristfriend.exception.GenericBusinessException;
//import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.finalist.util.log.*;
import sust.classnotfound.touristfriend.entity.*;

/**
 * The <code>UserService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class UserService implements IUserService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(UserService.class);


   /**
    * Default implementation for the Locatable Service interface.
    */
    public void init() {
    }

   /**
    * Default implementation for the Locatable Service interface.
    */
    public void destroy() {
    }

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/



   /**
    * Adds a new user to the database.
    *
    * @param model a data object
    * @return User a data object with the primary key
    */
   public sust.classnotfound.touristfriend.entity.User addUser(sust.classnotfound.touristfriend.entity.User model) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getUser(model.getPrimaryKey());
      } finally {
         log.debug("finished addUser(sust.classnotfound.touristfriend.entity.User model)");
      }
   }

   /**
    * Stores the <code>User</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveUser(sust.classnotfound.touristfriend.entity.User model) throws GenericBusinessException {
      // We have to create an object:
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveUser(sust.classnotfound.touristfriend.entity.User model)");
      }
   }

   /**
    * Removes a user.
    *
    * @param id the unique reference for the user
    */
   public void deleteUser(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         User bean = (User) hibernateTemplate.get(User.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteUser(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return User the data object
    */
   public sust.classnotfound.touristfriend.entity.User getUser(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
      User bean = (User) hibernateTemplate.get(User.class, id);
      return bean;
      } finally {
         log.debug("finished getUser(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all user instances.
    *
    * @return a list of User objects.
    */
   public List getUserList() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + User.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idUser";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getUserList");
      }
   }

   /**
    * Returns a subset of all user instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of user instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getUserListSize()</code> = last record),
    * any values greater than or equal to the total number of user instances will cause
    * the full set to be returned.
    * @return a list of User objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getUserList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getUserList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of user objects in the database.
    *
    * @return an integer value.
    */
   public int getUserListSize() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + User.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getUserListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idUser field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idUser the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByIdUser(java.lang.Integer idUser) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.idUser like :idUser ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idUser", idUser);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByIdUser(java.lang.Integer idUser)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userId the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByUserId(java.lang.Integer userId) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.userId like :userId ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userId", userId);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByUserId(java.lang.Integer userId)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified userName field.
     * To use a wildcard search, use a % in the query.
     *
     * @param userName the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByUserName(java.lang.String userName) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.userName like :userName ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "userName", userName);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByUserName(java.lang.String userName)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified email field.
     * To use a wildcard search, use a % in the query.
     *
     * @param email the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByEmail(java.lang.String email) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.email like :email ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "email", email);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByEmail(java.lang.String email)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified address field.
     * To use a wildcard search, use a % in the query.
     *
     * @param address the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByPassword(java.lang.String password) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.password like :password ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "password", password);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByAddress(java.lang.String password)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified validity field.
     * To use a wildcard search, use a % in the query.
     *
     * @param validity the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByValidity(java.lang.String validity) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.validity like :validity ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "validity", validity);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByValidity(java.lang.String validity)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified sex field.
     * To use a wildcard search, use a % in the query.
     *
     * @param sex the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserBySex(java.lang.String sex) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.sex like :sex ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "sex", sex);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserBySex(java.lang.String sex)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified dob field.
     * To use a wildcard search, use a % in the query.
     *
     * @param dob the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByDob(java.sql.Date dob) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.dob like :dob ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "dob", dob);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByDob(java.sql.Date dob)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idType field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idType the field
     * @return List of User data objects, empty list in case no results were found.
     */
    public java.util.List findUserByIdType(java.lang.Integer idType) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + User.class.getName() + " e where e.idType like :idType ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idUser";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idType", idType);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findUserByIdType(java.lang.Integer idType)");
      }
    }


}
