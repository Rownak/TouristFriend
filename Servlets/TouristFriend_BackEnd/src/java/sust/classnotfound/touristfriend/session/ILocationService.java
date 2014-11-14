package sust.classnotfound.touristfriend.session;

/**
 * The <code>LocationServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface ILocationService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new location to the storage.
    *
    * @param model a data object
    * @return Location a data object with the primary key
    */
   sust.classnotfound.touristfriend.entity.Location addLocation(sust.classnotfound.touristfriend.entity.Location model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Stores the <code>Location</code>.
    *
    * @param model the data model to store
    */
   void saveLocation(sust.classnotfound.touristfriend.entity.Location model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Removes a location.
    *
    * @param id the unique reference for the location
    */
   void deleteLocation(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Location the data object
    */
   sust.classnotfound.touristfriend.entity.Location getLocation(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a list of all location instances.
    *
    * @return a list of Location objects.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.Location> getLocationList() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a subset of all location instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of location instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getLocationListSize()</code> = last record),
    * any values greater than or equal to the total number of location instances will cause
    * the full set to be returned.
    * @return a collection of Location objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.Location> getLocationList(int startIndex, int endIndex) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Obtains the total number of location objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getLocationListSize() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idLocation field.
     *
     * @param idLocation the field
     * @return List of Location data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Location> findLocationByIdLocation(java.lang.Integer idLocation) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified locationName field.
     *
     * @param locationName the field
     * @return List of Location data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Location> findLocationByLocationName(java.lang.String locationName) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified latitude field.
     *
     * @param latitude the field
     * @return List of Location data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Location> findLocationByLatitude(java.lang.Double latitude) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified longitude field.
     *
     * @param longitude the field
     * @return List of Location data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Location> findLocationByLongitude(java.lang.Double longitude) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idDistrict field.
     *
     * @param idDistrict the field
     * @return List of Location data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Location> findLocationByIdDistrict(java.lang.Integer idDistrict) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;


}
