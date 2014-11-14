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
 * The <code>TypeService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class TypeService implements ITypeService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(TypeService.class);


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
    * Adds a new type to the database.
    *
    * @param model a data object
    * @return Type a data object with the primary key
    */
   public sust.classnotfound.touristfriend.entity.Type addType(sust.classnotfound.touristfriend.entity.Type model) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getType(model.getPrimaryKey());
      } finally {
         log.debug("finished addType(sust.classnotfound.touristfriend.entity.Type model)");
      }
   }

   /**
    * Stores the <code>Type</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveType(sust.classnotfound.touristfriend.entity.Type model) throws GenericBusinessException {
      // We have to create an object:
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveType(sust.classnotfound.touristfriend.entity.Type model)");
      }
   }

   /**
    * Removes a type.
    *
    * @param id the unique reference for the type
    */
   public void deleteType(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Type bean = (Type) hibernateTemplate.get(Type.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteType(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Type the data object
    */
   public sust.classnotfound.touristfriend.entity.Type getType(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
      Type bean = (Type) hibernateTemplate.get(Type.class, id);
      return bean;
      } finally {
         log.debug("finished getType(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all type instances.
    *
    * @return a list of Type objects.
    */
   public List getTypeList() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Type.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idType";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getTypeList");
      }
   }

   /**
    * Returns a subset of all type instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of type instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getTypeListSize()</code> = last record),
    * any values greater than or equal to the total number of type instances will cause
    * the full set to be returned.
    * @return a list of Type objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getTypeList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Type.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getTypeList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of type objects in the database.
    *
    * @return an integer value.
    */
   public int getTypeListSize() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Type.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getTypeListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idType field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idType the field
     * @return List of Type data objects, empty list in case no results were found.
     */
    public java.util.List findTypeByIdType(java.lang.Integer idType) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Type.class.getName() + " e where e.idType like :idType ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idType", idType);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findTypeByIdType(java.lang.Integer idType)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified name field.
     * To use a wildcard search, use a % in the query.
     *
     * @param name the field
     * @return List of Type data objects, empty list in case no results were found.
     */
    public java.util.List findTypeByName(java.lang.String name) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Type.class.getName() + " e where e.name like :name ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "name", name);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findTypeByName(java.lang.String name)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified description field.
     * To use a wildcard search, use a % in the query.
     *
     * @param description the field
     * @return List of Type data objects, empty list in case no results were found.
     */
    public java.util.List findTypeByDescription(java.lang.String description) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Type.class.getName() + " e where e.description like :description ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idType";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "description", description);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findTypeByDescription(java.lang.String description)");
      }
    }


}
