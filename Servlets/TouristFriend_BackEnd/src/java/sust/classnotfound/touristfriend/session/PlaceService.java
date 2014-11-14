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
 * The <code>PlaceService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class PlaceService implements IPlaceService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(PlaceService.class);


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
    * Adds a new place to the database.
    *
    * @param model a data object
    * @return Place a data object with the primary key
    */
   public sust.classnotfound.touristfriend.entity.Place addPlace(sust.classnotfound.touristfriend.entity.Place model) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getPlace(model.getPrimaryKey());
      } finally {
         log.debug("finished addPlace(sust.classnotfound.touristfriend.entity.Place model)");
      }
   }

   /**
    * Stores the <code>Place</code> in the database.
    *
    * @param model the data model to store
    */
   public void savePlace(sust.classnotfound.touristfriend.entity.Place model) throws GenericBusinessException {
      // We have to create an object:
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished savePlace(sust.classnotfound.touristfriend.entity.Place model)");
      }
   }

   /**
    * Removes a place.
    *
    * @param id the unique reference for the place
    */
   public void deletePlace(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Place bean = (Place) hibernateTemplate.get(Place.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deletePlace(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Place the data object
    */
   public sust.classnotfound.touristfriend.entity.Place getPlace(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
      Place bean = (Place) hibernateTemplate.get(Place.class, id);
      return bean;
      } finally {
         log.debug("finished getPlace(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all place instances.
    *
    * @return a list of Place objects.
    */
   public List getPlaceList() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Place.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idPlace";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getPlaceList");
      }
   }

   /**
    * Returns a subset of all place instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of place instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getPlaceListSize()</code> = last record),
    * any values greater than or equal to the total number of place instances will cause
    * the full set to be returned.
    * @return a list of Place objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getPlaceList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Place.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPlace";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getPlaceList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of place objects in the database.
    *
    * @return an integer value.
    */
   public int getPlaceListSize() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Place.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getPlaceListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idPlace field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idPlace the field
     * @return List of Place data objects, empty list in case no results were found.
     */
    public java.util.List findPlaceByIdPlace(java.lang.Integer idPlace) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Place.class.getName() + " e where e.idPlace like :idPlace ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPlace";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idPlace", idPlace);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPlaceByIdPlace(java.lang.Integer idPlace)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified name field.
     * To use a wildcard search, use a % in the query.
     *
     * @param name the field
     * @return List of Place data objects, empty list in case no results were found.
     */
    public java.util.List findPlaceByName(java.lang.String name) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Place.class.getName() + " e where e.name like :name ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPlace";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "name", name);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPlaceByName(java.lang.String name)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified description field.
     * To use a wildcard search, use a % in the query.
     *
     * @param description the field
     * @return List of Place data objects, empty list in case no results were found.
     */
    public java.util.List findPlaceByDescription(java.lang.String description) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Place.class.getName() + " e where e.description like :description ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPlace";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "description", description);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPlaceByDescription(java.lang.String description)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified latitude field.
     * To use a wildcard search, use a % in the query.
     *
     * @param latitude the field
     * @return List of Place data objects, empty list in case no results were found.
     */
    public java.util.List findPlaceByLatitude(java.lang.Double latitude) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Place.class.getName() + " e where e.latitude like :latitude ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPlace";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "latitude", latitude);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPlaceByLatitude(java.lang.Double latitude)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified longitude field.
     * To use a wildcard search, use a % in the query.
     *
     * @param longitude the field
     * @return List of Place data objects, empty list in case no results were found.
     */
    public java.util.List findPlaceByLongitude(java.lang.Double longitude) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Place.class.getName() + " e where e.longitude like :longitude ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPlace";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "longitude", longitude);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPlaceByLongitude(java.lang.Double longitude)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idLocation field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idLocation the field
     * @return List of Place data objects, empty list in case no results were found.
     */
    public java.util.List findPlaceByIdLocation(java.lang.Integer idLocation) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Place.class.getName() + " e where e.idLocation like :idLocation ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPlace";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idLocation", idLocation);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPlaceByIdLocation(java.lang.Integer idLocation)");
      }
    }


}
