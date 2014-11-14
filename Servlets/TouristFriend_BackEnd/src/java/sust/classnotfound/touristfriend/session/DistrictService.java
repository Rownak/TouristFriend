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
 * The <code>DistrictService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class DistrictService implements IDistrictService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(DistrictService.class);


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
    * Adds a new district to the database.
    *
    * @param model a data object
    * @return District a data object with the primary key
    */
   public sust.classnotfound.touristfriend.entity.District addDistrict(sust.classnotfound.touristfriend.entity.District model) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getDistrict(model.getPrimaryKey());
      } finally {
         log.debug("finished addDistrict(sust.classnotfound.touristfriend.entity.District model)");
      }
   }

   /**
    * Stores the <code>District</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveDistrict(sust.classnotfound.touristfriend.entity.District model) throws GenericBusinessException {
      // We have to create an object:
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveDistrict(sust.classnotfound.touristfriend.entity.District model)");
      }
   }

   /**
    * Removes a district.
    *
    * @param id the unique reference for the district
    */
   public void deleteDistrict(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         District bean = (District) hibernateTemplate.get(District.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteDistrict(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return District the data object
    */
   public sust.classnotfound.touristfriend.entity.District getDistrict(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
      District bean = (District) hibernateTemplate.get(District.class, id);
      return bean;
      } finally {
         log.debug("finished getDistrict(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all district instances.
    *
    * @return a list of District objects.
    */
   public List getDistrictList() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + District.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idDistrict";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getDistrictList");
      }
   }

   /**
    * Returns a subset of all district instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of district instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getDistrictListSize()</code> = last record),
    * any values greater than or equal to the total number of district instances will cause
    * the full set to be returned.
    * @return a list of District objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getDistrictList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + District.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idDistrict";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getDistrictList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of district objects in the database.
    *
    * @return an integer value.
    */
   public int getDistrictListSize() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + District.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getDistrictListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idDistrict field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idDistrict the field
     * @return List of District data objects, empty list in case no results were found.
     */
    public java.util.List findDistrictByIdDistrict(java.lang.Integer idDistrict) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + District.class.getName() + " e where e.idDistrict like :idDistrict ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idDistrict";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idDistrict", idDistrict);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findDistrictByIdDistrict(java.lang.Integer idDistrict)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified latitude field.
     * To use a wildcard search, use a % in the query.
     *
     * @param latitude the field
     * @return List of District data objects, empty list in case no results were found.
     */
    public java.util.List findDistrictByLatitude(java.lang.Double latitude) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + District.class.getName() + " e where e.latitude like :latitude ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idDistrict";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "latitude", latitude);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findDistrictByLatitude(java.lang.Double latitude)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified longitude field.
     * To use a wildcard search, use a % in the query.
     *
     * @param longitude the field
     * @return List of District data objects, empty list in case no results were found.
     */
    public java.util.List findDistrictByLongitude(java.lang.Double longitude) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + District.class.getName() + " e where e.longitude like :longitude ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idDistrict";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "longitude", longitude);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findDistrictByLongitude(java.lang.Double longitude)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified districtName field.
     * To use a wildcard search, use a % in the query.
     *
     * @param districtName the field
     * @return List of District data objects, empty list in case no results were found.
     */
    public java.util.List findDistrictByDistrictName(java.lang.String districtName) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + District.class.getName() + " e where e.districtName like :districtName ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idDistrict";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "districtName", districtName);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findDistrictByDistrictName(java.lang.String districtName)");
      }
    }


}
