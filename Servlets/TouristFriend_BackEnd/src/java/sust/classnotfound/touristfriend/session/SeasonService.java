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
 * The <code>SeasonService</code> session bean, which acts as a facade to the
 * underlying entity beans.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.19 $, $Date: 2006/04/29 12:39:09 $
 *
 */
public class SeasonService implements ISeasonService , LocatableService {
   /**
    * The logger object.
    */
   private static Logger log = LogService.getLogger(SeasonService.class);


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
    * Adds a new season to the database.
    *
    * @param model a data object
    * @return Season a data object with the primary key
    */
   public sust.classnotfound.touristfriend.entity.Season addSeason(sust.classnotfound.touristfriend.entity.Season model) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         hibernateTemplate.save(model);
         return getSeason(model.getPrimaryKey());
      } finally {
         log.debug("finished addSeason(sust.classnotfound.touristfriend.entity.Season model)");
      }
   }

   /**
    * Stores the <code>Season</code> in the database.
    *
    * @param model the data model to store
    */
   public void saveSeason(sust.classnotfound.touristfriend.entity.Season model) throws GenericBusinessException {
      // We have to create an object:
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // Now update the data.
         hibernateTemplate.update(model);
      } finally {
         log.debug("finished saveSeason(sust.classnotfound.touristfriend.entity.Season model)");
      }
   }

   /**
    * Removes a season.
    *
    * @param id the unique reference for the season
    */
   public void deleteSeason(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         // First get the data.
         Season bean = (Season) hibernateTemplate.get(Season.class, id);
         hibernateTemplate.delete(bean);
      } finally {
         log.debug("finished deleteSeason(java.lang.Integer id)");
      }
   }

   /**
    * Retrieves a data object from the database by its primary key.
    *
    * @param id the unique reference
    * @return Season the data object
    */
   public sust.classnotfound.touristfriend.entity.Season getSeason(java.lang.Integer id) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
      Season bean = (Season) hibernateTemplate.get(Season.class, id);
      return bean;
      } finally {
         log.debug("finished getSeason(java.lang.Integer id)");
      }
   }

   /**
    * Returns a list of all season instances.
    *
    * @return a list of Season objects.
    */
   public List getSeasonList() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {

      String queryString = "from " + Season.class.getName() + " e";
      // Add a an order by on all primary keys to assure reproducable results.
      String orderByPart = "";
      orderByPart += " order by e.idSeason";
      queryString += orderByPart;
      Query query = hibernateTemplate.createQuery(queryString);
      List list = hibernateTemplate.list(query);

      return list;
      } finally {
         log.debug("finished getSeasonList");
      }
   }

   /**
    * Returns a subset of all season instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of season instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getSeasonListSize()</code> = last record),
    * any values greater than or equal to the total number of season instances will cause
    * the full set to be returned.
    * @return a list of Season objects, of size <code>(endIndex - startIndex)</code>.
    */
   public List getSeasonList(int startIndex, int endIndex) throws GenericBusinessException {
      if (startIndex < 1) {
         startIndex = 1;
      }
      if ( (endIndex - startIndex) < 0) {
         // Just return an empty list.
         return new ArrayList();
      }
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Season.class.getName() + " e";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idSeason";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         query.setFirstResult(startIndex - 1);
         query.setMaxResults(endIndex - startIndex + 1);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished getSeasonList(int startIndex, int endIndex)");
      }
   }

   /**
    * Obtains the total number of season objects in the database.
    *
    * @return an integer value.
    */
   public int getSeasonListSize() throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "select count(*) from " + Season.class.getName();
         Query query = hibernateTemplate.createQuery(queryString);
         List list = hibernateTemplate.list(query);
         Integer countResult = (Integer) list.get(0);
         return countResult.intValue();
      } finally {
         log.debug("finished getSeasonListSize()");
      }
   }

    /**
     *
     * Retrieves a list of data object for the specified idSeason field.
     * To use a wildcard search, use a % in the query.
     *
     * @param idSeason the field
     * @return List of Season data objects, empty list in case no results were found.
     */
    public java.util.List findSeasonByIdSeason(java.lang.Integer idSeason) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Season.class.getName() + " e where e.idSeason like :idSeason ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idSeason";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "idSeason", idSeason);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findSeasonByIdSeason(java.lang.Integer idSeason)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified name field.
     * To use a wildcard search, use a % in the query.
     *
     * @param name the field
     * @return List of Season data objects, empty list in case no results were found.
     */
    public java.util.List findSeasonByName(java.lang.String name) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Season.class.getName() + " e where e.name like :name ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idSeason";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "name", name);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findSeasonByName(java.lang.String name)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified description field.
     * To use a wildcard search, use a % in the query.
     *
     * @param description the field
     * @return List of Season data objects, empty list in case no results were found.
     */
    public java.util.List findSeasonByDescription(java.lang.String description) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Season.class.getName() + " e where e.description like :description ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idSeason";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "description", description);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findSeasonByDescription(java.lang.String description)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified startingDate field.
     * To use a wildcard search, use a % in the query.
     *
     * @param startingDate the field
     * @return List of Season data objects, empty list in case no results were found.
     */
    public java.util.List findSeasonByStartingDate(java.sql.Date startingDate) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Season.class.getName() + " e where e.startingDate like :startingDate ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idSeason";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "startingDate", startingDate);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findSeasonByStartingDate(java.sql.Date startingDate)");
      }
    }
    /**
     *
     * Retrieves a list of data object for the specified endingDate field.
     * To use a wildcard search, use a % in the query.
     *
     * @param endingDate the field
     * @return List of Season data objects, empty list in case no results were found.
     */
    public java.util.List findSeasonByEndingDate(java.sql.Date endingDate) throws GenericBusinessException {
      sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper hibernateTemplate = new sust.classnotfound.touristfriend.hibernatehelper.HibernateQueryHelper();
      try {
         String queryString = "from " + Season.class.getName() + " e where e.endingDate like :endingDate ";
         // Add a an order by on all primary keys to assure reproducable results.
         String orderByPart = "";
         orderByPart += " order by e.idSeason";
         queryString += orderByPart;
         Query query = hibernateTemplate.createQuery(queryString);
         hibernateTemplate.setQueryParameter(query, "endingDate", endingDate);
         List list = hibernateTemplate.list(query);
         return list;
      } finally {
         log.debug("finished findSeasonByEndingDate(java.sql.Date endingDate)");
      }
    }


}
