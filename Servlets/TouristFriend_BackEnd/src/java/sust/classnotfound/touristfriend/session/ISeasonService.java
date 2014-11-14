package sust.classnotfound.touristfriend.session;

/**
 * The <code>SeasonServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface ISeasonService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new season to the storage.
    *
    * @param model a data object
    * @return Season a data object with the primary key
    */
   sust.classnotfound.touristfriend.entity.Season addSeason(sust.classnotfound.touristfriend.entity.Season model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Stores the <code>Season</code>.
    *
    * @param model the data model to store
    */
   void saveSeason(sust.classnotfound.touristfriend.entity.Season model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Removes a season.
    *
    * @param id the unique reference for the season
    */
   void deleteSeason(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Season the data object
    */
   sust.classnotfound.touristfriend.entity.Season getSeason(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a list of all season instances.
    *
    * @return a list of Season objects.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.Season> getSeasonList() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a subset of all season instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of season instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getSeasonListSize()</code> = last record),
    * any values greater than or equal to the total number of season instances will cause
    * the full set to be returned.
    * @return a collection of Season objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.Season> getSeasonList(int startIndex, int endIndex) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Obtains the total number of season objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getSeasonListSize() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idSeason field.
     *
     * @param idSeason the field
     * @return List of Season data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Season> findSeasonByIdSeason(java.lang.Integer idSeason) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified name field.
     *
     * @param name the field
     * @return List of Season data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Season> findSeasonByName(java.lang.String name) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified description field.
     *
     * @param description the field
     * @return List of Season data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Season> findSeasonByDescription(java.lang.String description) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified startingDate field.
     *
     * @param startingDate the field
     * @return List of Season data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Season> findSeasonByStartingDate(java.sql.Date startingDate) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified endingDate field.
     *
     * @param endingDate the field
     * @return List of Season data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Season> findSeasonByEndingDate(java.sql.Date endingDate) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;


}
