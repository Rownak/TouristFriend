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
 * The <code>LocationService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class LocationService implements ILocationService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(LocationService.class);


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
    * Adds a new location to the database.
    *
    * @param model a data object
    * @return Location a data object with the primary key
    */
   public sust.classnotfound.touristfriend.entity.Location addLocation(sust.classnotfound.touristfriend.entity.Location model) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getLocation(model.getPrimaryKey());
      } finally {
         log.debug("finished addLocation(sust.classnotfound.touristfriend.entity.Location model)");
      }
   }

   /**
    * Stores the <code>Location</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveLocation(sust.classnotfound.touristfriend.entity.Location model) throws GenericBusinessException {
      // We have to create an object:
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveLocation(sust.classnotfound.touristfriend.entity.Location model)");
      }
   }

   /**
    * Removes a location.
    *
    * @param id the unique reference for the location
    */
   public void deleteLocation(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Location bean = (Location) hibernateTemplate.get(Location.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteLocation(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Location the data object
    */
   public sust.classnotfound.touristfriend.entity.Location getLocation(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
      Location bean = (Location) hibernateTemplate.get(Location.class, id);
      return bean;
      } finally {
         log.debug("finished getLocation(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all location instances.
    *
    * @return a list of Location objects.
    */
   public List getLocationList() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Location.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idLocation";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getLocationList");
      }
   }

   /**
    * Returns a subset of all location instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of location instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getLocationListSize()</code> = last record),
    * any values greater than or equal to the total number of location instances will cause
    * the full set to be returned.
    * @return a list of Location objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getLocationList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Location.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idLocation";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getLocationList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of location objects in the database.
    *
    * @return an integer value.
    */
   public int getLocationListSize() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Location.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getLocationListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idLocation field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idLocation the field
     * @return List of Location data objects, empty list in case no results were found.
     */
    public java.util.List findLocationByIdLocation(java.lang.Integer idLocation) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Location.class.getName() + " e where e.idLocation like :idLocation ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idLocation";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idLocation", idLocation);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findLocationByIdLocation(java.lang.Integer idLocation)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified locationName field.
     * To use a wildcard search, use a % in the query.
     *
     * @param locationName the field
     * @return List of Location data objects, empty list in case no results were found.
     */
    public java.util.List findLocationByLocationName(java.lang.String locationName) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Location.class.getName() + " e where e.locationName like :locationName ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idLocation";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "locationName", locationName);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findLocationByLocationName(java.lang.String locationName)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified latitude field.
     * To use a wildcard search, use a % in the query.
     *
     * @param latitude the field
     * @return List of Location data objects, empty list in case no results were found.
     */
    public java.util.List findLocationByLatitude(java.lang.Double latitude) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Location.class.getName() + " e where e.latitude like :latitude ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idLocation";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "latitude", latitude);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findLocationByLatitude(java.lang.Double latitude)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified longitude field.
     * To use a wildcard search, use a % in the query.
     *
     * @param longitude the field
     * @return List of Location data objects, empty list in case no results were found.
     */
    public java.util.List findLocationByLongitude(java.lang.Double longitude) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Location.class.getName() + " e where e.longitude like :longitude ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idLocation";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "longitude", longitude);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findLocationByLongitude(java.lang.Double longitude)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idDistrict field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idDistrict the field
     * @return List of Location data objects, empty list in case no results were found.
     */
    public java.util.List findLocationByIdDistrict(java.lang.Integer idDistrict) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Location.class.getName() + " e where e.idDistrict like :idDistrict ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idLocation";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idDistrict", idDistrict);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findLocationByIdDistrict(java.lang.Integer idDistrict)");
      }
    }


}
