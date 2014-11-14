package sust.classnotfound.touristfriend.session;

/**
 * The <code>PlaceServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IPlaceService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new place to the storage.
    *
    * @param model a data object
    * @return Place a data object with the primary key
    */
   sust.classnotfound.touristfriend.entity.Place addPlace(sust.classnotfound.touristfriend.entity.Place model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Stores the <code>Place</code>.
    *
    * @param model the data model to store
    */
   void savePlace(sust.classnotfound.touristfriend.entity.Place model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Removes a place.
    *
    * @param id the unique reference for the place
    */
   void deletePlace(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Place the data object
    */
   sust.classnotfound.touristfriend.entity.Place getPlace(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a list of all place instances.
    *
    * @return a list of Place objects.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.Place> getPlaceList() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a subset of all place instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of place instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getPlaceListSize()</code> = last record),
    * any values greater than or equal to the total number of place instances will cause
    * the full set to be returned.
    * @return a collection of Place objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.Place> getPlaceList(int startIndex, int endIndex) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Obtains the total number of place objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getPlaceListSize() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idPlace field.
     *
     * @param idPlace the field
     * @return List of Place data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Place> findPlaceByIdPlace(java.lang.Integer idPlace) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified name field.
     *
     * @param name the field
     * @return List of Place data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Place> findPlaceByName(java.lang.String name) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified description field.
     *
     * @param description the field
     * @return List of Place data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Place> findPlaceByDescription(java.lang.String description) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified latitude field.
     *
     * @param latitude the field
     * @return List of Place data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Place> findPlaceByLatitude(java.lang.Double latitude) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified longitude field.
     *
     * @param longitude the field
     * @return List of Place data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Place> findPlaceByLongitude(java.lang.Double longitude) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idLocation field.
     *
     * @param idLocation the field
     * @return List of Place data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Place> findPlaceByIdLocation(java.lang.Integer idLocation) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;


}
