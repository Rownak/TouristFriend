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
 * The <code>RatingMappingService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class RatingMappingService implements IRatingMappingService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(RatingMappingService.class);


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
    * Adds a new ratingMapping to the database.
    *
    * @param model a data object
    * @return RatingMapping a data object with the primary key
    */
   public sust.classnotfound.touristfriend.entity.RatingMapping addRatingMapping(sust.classnotfound.touristfriend.entity.RatingMapping model) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getRatingMapping(model.getPrimaryKey());
      } finally {
         log.debug("finished addRatingMapping(sust.classnotfound.touristfriend.entity.RatingMapping model)");
      }
   }

   /**
    * Stores the <code>RatingMapping</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveRatingMapping(sust.classnotfound.touristfriend.entity.RatingMapping model) throws GenericBusinessException {
      // We have to create an object:
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveRatingMapping(sust.classnotfound.touristfriend.entity.RatingMapping model)");
      }
   }

   /**
    * Removes a ratingMapping.
    *
    * @param id the unique reference for the ratingMapping
    */
   public void deleteRatingMapping(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         RatingMapping bean = (RatingMapping) hibernateTemplate.get(RatingMapping.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteRatingMapping(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return RatingMapping the data object
    */
   public sust.classnotfound.touristfriend.entity.RatingMapping getRatingMapping(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
      RatingMapping bean = (RatingMapping) hibernateTemplate.get(RatingMapping.class, id);
      return bean;
      } finally {
         log.debug("finished getRatingMapping(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all ratingMapping instances.
    *
    * @return a list of RatingMapping objects.
    */
   public List getRatingMappingList() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + RatingMapping.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idRating";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getRatingMappingList");
      }
   }

   /**
    * Returns a subset of all ratingMapping instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of ratingMapping instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getRatingMappingListSize()</code> = last record),
    * any values greater than or equal to the total number of ratingMapping instances will cause
    * the full set to be returned.
    * @return a list of RatingMapping objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getRatingMappingList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + RatingMapping.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idRating";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getRatingMappingList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of ratingMapping objects in the database.
    *
    * @return an integer value.
    */
   public int getRatingMappingListSize() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + RatingMapping.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getRatingMappingListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idRating field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idRating the field
     * @return List of RatingMapping data objects, empty list in case no results were found.
     */
    public java.util.List findRatingMappingByIdRating(java.lang.Integer idRating) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + RatingMapping.class.getName() + " e where e.idRating like :idRating ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idRating";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idRating", idRating);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRatingMappingByIdRating(java.lang.Integer idRating)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idSeason field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idSeason the field
     * @return List of RatingMapping data objects, empty list in case no results were found.
     */
    public java.util.List findRatingMappingByIdSeason(java.lang.Integer idSeason) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + RatingMapping.class.getName() + " e where e.idSeason like :idSeason ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idRating";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idSeason", idSeason);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRatingMappingByIdSeason(java.lang.Integer idSeason)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idPlace field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idPlace the field
     * @return List of RatingMapping data objects, empty list in case no results were found.
     */
    public java.util.List findRatingMappingByIdPlace(java.lang.Integer idPlace) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + RatingMapping.class.getName() + " e where e.idPlace like :idPlace ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idRating";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idPlace", idPlace);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRatingMappingByIdPlace(java.lang.Integer idPlace)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified rating field.
     * To use a wildcard search, use a % in the query.
     *
     * @param rating the field
     * @return List of RatingMapping data objects, empty list in case no results were found.
     */
    public java.util.List findRatingMappingByRating(java.lang.Double rating) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + RatingMapping.class.getName() + " e where e.rating like :rating ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idRating";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "rating", rating);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findRatingMappingByRating(java.lang.Double rating)");
      }
    }


}
