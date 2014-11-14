package sust.classnotfound.touristfriend.session;

/**
 * The <code>RatingMappingServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IRatingMappingService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new ratingMapping to the storage.
    *
    * @param model a data object
    * @return RatingMapping a data object with the primary key
    */
   sust.classnotfound.touristfriend.entity.RatingMapping addRatingMapping(sust.classnotfound.touristfriend.entity.RatingMapping model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Stores the <code>RatingMapping</code>.
    *
    * @param model the data model to store
    */
   void saveRatingMapping(sust.classnotfound.touristfriend.entity.RatingMapping model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Removes a ratingMapping.
    *
    * @param id the unique reference for the ratingMapping
    */
   void deleteRatingMapping(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return RatingMapping the data object
    */
   sust.classnotfound.touristfriend.entity.RatingMapping getRatingMapping(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a list of all ratingMapping instances.
    *
    * @return a list of RatingMapping objects.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.RatingMapping> getRatingMappingList() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a subset of all ratingMapping instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of ratingMapping instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getRatingMappingListSize()</code> = last record),
    * any values greater than or equal to the total number of ratingMapping instances will cause
    * the full set to be returned.
    * @return a collection of RatingMapping objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.RatingMapping> getRatingMappingList(int startIndex, int endIndex) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Obtains the total number of ratingMapping objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getRatingMappingListSize() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idRating field.
     *
     * @param idRating the field
     * @return List of RatingMapping data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.RatingMapping> findRatingMappingByIdRating(java.lang.Integer idRating) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idSeason field.
     *
     * @param idSeason the field
     * @return List of RatingMapping data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.RatingMapping> findRatingMappingByIdSeason(java.lang.Integer idSeason) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idPlace field.
     *
     * @param idPlace the field
     * @return List of RatingMapping data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.RatingMapping> findRatingMappingByIdPlace(java.lang.Integer idPlace) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified rating field.
     *
     * @param rating the field
     * @return List of RatingMapping data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.RatingMapping> findRatingMappingByRating(java.lang.Double rating) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;


}
