package sust.classnotfound.touristfriend.session;

/**
 * The <code>PhotosServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IPhotosService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new photos to the storage.
    *
    * @param model a data object
    * @return Photos a data object with the primary key
    */
   sust.classnotfound.touristfriend.entity.Photos addPhotos(sust.classnotfound.touristfriend.entity.Photos model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Stores the <code>Photos</code>.
    *
    * @param model the data model to store
    */
   void savePhotos(sust.classnotfound.touristfriend.entity.Photos model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Removes a photos.
    *
    * @param id the unique reference for the photos
    */
   void deletePhotos(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Photos the data object
    */
   sust.classnotfound.touristfriend.entity.Photos getPhotos(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a list of all photos instances.
    *
    * @return a list of Photos objects.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.Photos> getPhotosList() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a subset of all photos instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of photos instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getPhotosListSize()</code> = last record),
    * any values greater than or equal to the total number of photos instances will cause
    * the full set to be returned.
    * @return a collection of Photos objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.Photos> getPhotosList(int startIndex, int endIndex) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Obtains the total number of photos objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getPhotosListSize() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idPhotos field.
     *
     * @param idPhotos the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Photos> findPhotosByIdPhotos(java.lang.Integer idPhotos) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified lat field.
     *
     * @param lat the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Photos> findPhotosByLat(java.lang.Double lat) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified lang field.
     *
     * @param lang the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Photos> findPhotosByLang(java.lang.Double lang) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified rating field.
     *
     * @param rating the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Photos> findPhotosByRating(java.lang.Double rating) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified numOfUserRated field.
     *
     * @param numOfUserRated the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Photos> findPhotosByNumOfUserRated(java.lang.Integer numOfUserRated) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified date field.
     *
     * @param date the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Photos> findPhotosByDate(java.sql.Date date) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified description field.
     *
     * @param description the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Photos> findPhotosByDescription(java.lang.String description) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idSeason field.
     *
     * @param idSeason the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Photos> findPhotosByIdSeason(java.lang.Integer idSeason) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idPlace field.
     *
     * @param idPlace the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Photos> findPhotosByIdPlace(java.lang.Integer idPlace) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idUser field.
     *
     * @param idUser the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Photos> findPhotosByIdUser(java.lang.Integer idUser) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified photoUrl field.
     *
     * @param photoUrl the field
     * @return List of Photos data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Photos> findPhotosByPhotoUrl(java.lang.String photoUrl) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;


}
