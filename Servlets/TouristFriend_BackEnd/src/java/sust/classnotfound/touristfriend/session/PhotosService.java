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
 * The <code>PhotosService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class PhotosService implements IPhotosService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(PhotosService.class);


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
    * Adds a new photos to the database.
    *
    * @param model a data object
    * @return Photos a data object with the primary key
    */
   public sust.classnotfound.touristfriend.entity.Photos addPhotos(sust.classnotfound.touristfriend.entity.Photos model) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getPhotos(model.getPrimaryKey());
      } finally {
         log.debug("finished addPhotos(sust.classnotfound.touristfriend.entity.Photos model)");
      }
   }

   /**
    * Stores the <code>Photos</code> in the database.
    *
    * @param model the data model to store
    */
   public void savePhotos(sust.classnotfound.touristfriend.entity.Photos model) throws GenericBusinessException {
      // We have to create an object:
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished savePhotos(sust.classnotfound.touristfriend.entity.Photos model)");
      }
   }

   /**
    * Removes a photos.
    *
    * @param id the unique reference for the photos
    */
   public void deletePhotos(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Photos bean = (Photos) hibernateTemplate.get(Photos.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deletePhotos(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Photos the data object
    */
   public sust.classnotfound.touristfriend.entity.Photos getPhotos(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
      Photos bean = (Photos) hibernateTemplate.get(Photos.class, id);
      return bean;
      } finally {
         log.debug("finished getPhotos(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all photos instances.
    *
    * @return a list of Photos objects.
    */
   public List getPhotosList() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Photos.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idPhotos";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getPhotosList");
      }
   }

   /**
    * Returns a subset of all photos instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of photos instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getPhotosListSize()</code> = last record),
    * any values greater than or equal to the total number of photos instances will cause
    * the full set to be returned.
    * @return a list of Photos objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getPhotosList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Photos.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPhotos";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getPhotosList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of photos objects in the database.
    *
    * @return an integer value.
    */
   public int getPhotosListSize() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Photos.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getPhotosListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idPhotos field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idPhotos the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    public java.util.List findPhotosByIdPhotos(java.lang.Integer idPhotos) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Photos.class.getName() + " e where e.idPhotos like :idPhotos ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPhotos";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idPhotos", idPhotos);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPhotosByIdPhotos(java.lang.Integer idPhotos)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified lat field.
     * To use a wildcard search, use a % in the query.
     *
     * @param lat the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    public java.util.List findPhotosByLat(java.lang.Double lat) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Photos.class.getName() + " e where e.lat like :lat ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPhotos";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "lat", lat);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPhotosByLat(java.lang.Double lat)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified lang field.
     * To use a wildcard search, use a % in the query.
     *
     * @param lang the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    public java.util.List findPhotosByLang(java.lang.Double lang) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Photos.class.getName() + " e where e.lang like :lang ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPhotos";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "lang", lang);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPhotosByLang(java.lang.Double lang)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified rating field.
     * To use a wildcard search, use a % in the query.
     *
     * @param rating the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    public java.util.List findPhotosByRating(java.lang.Double rating) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Photos.class.getName() + " e where e.rating like :rating ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPhotos";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "rating", rating);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPhotosByRating(java.lang.Double rating)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified numOfUserRated field.
     * To use a wildcard search, use a % in the query.
     *
     * @param numOfUserRated the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    public java.util.List findPhotosByNumOfUserRated(java.lang.Integer numOfUserRated) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Photos.class.getName() + " e where e.numOfUserRated like :numOfUserRated ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPhotos";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "numOfUserRated", numOfUserRated);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPhotosByNumOfUserRated(java.lang.Integer numOfUserRated)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified date field.
     * To use a wildcard search, use a % in the query.
     *
     * @param date the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    public java.util.List findPhotosByDate(java.sql.Date date) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Photos.class.getName() + " e where e.date like :date ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPhotos";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "date", date);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPhotosByDate(java.sql.Date date)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified description field.
     * To use a wildcard search, use a % in the query.
     *
     * @param description the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    public java.util.List findPhotosByDescription(java.lang.String description) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Photos.class.getName() + " e where e.description like :description ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPhotos";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "description", description);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPhotosByDescription(java.lang.String description)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idSeason field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idSeason the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    public java.util.List findPhotosByIdSeason(java.lang.Integer idSeason) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Photos.class.getName() + " e where e.idSeason like :idSeason ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPhotos";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idSeason", idSeason);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPhotosByIdSeason(java.lang.Integer idSeason)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idPlace field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idPlace the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    public java.util.List findPhotosByIdPlace(java.lang.Integer idPlace) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Photos.class.getName() + " e where e.idPlace like :idPlace ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPhotos";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idPlace", idPlace);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPhotosByIdPlace(java.lang.Integer idPlace)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified idUser field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idUser the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    public java.util.List findPhotosByIdUser(java.lang.Integer idUser) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Photos.class.getName() + " e where e.idUser like :idUser ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPhotos";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idUser", idUser);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPhotosByIdUser(java.lang.Integer idUser)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified photoUrl field.
     * To use a wildcard search, use a % in the query.
     *
     * @param photoUrl the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    public java.util.List findPhotosByPhotoUrl(java.lang.String photoUrl) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Photos.class.getName() + " e where e.photoUrl like :photoUrl ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idPhotos";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "photoUrl", photoUrl);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findPhotosByPhotoUrl(java.lang.String photoUrl)");
      }
    }


}
