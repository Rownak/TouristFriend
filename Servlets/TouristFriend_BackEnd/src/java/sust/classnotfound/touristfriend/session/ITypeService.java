package sust.classnotfound.touristfriend.session;

/**
 * The <code>TypeServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface ITypeService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new type to the storage.
    *
    * @param model a data object
    * @return Type a data object with the primary key
    */
   sust.classnotfound.touristfriend.entity.Type addType(sust.classnotfound.touristfriend.entity.Type model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Stores the <code>Type</code>.
    *
    * @param model the data model to store
    */
   void saveType(sust.classnotfound.touristfriend.entity.Type model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Removes a type.
    *
    * @param id the unique reference for the type
    */
   void deleteType(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return Type the data object
    */
   sust.classnotfound.touristfriend.entity.Type getType(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a list of all type instances.
    *
    * @return a list of Type objects.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.Type> getTypeList() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a subset of all type instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of type instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getTypeListSize()</code> = last record),
    * any values greater than or equal to the total number of type instances will cause
    * the full set to be returned.
    * @return a collection of Type objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.Type> getTypeList(int startIndex, int endIndex) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Obtains the total number of type objects in the storage.
    * <b>NOTE:</b>If this session façade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getTypeListSize() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idType field.
     *
     * @param idType the field
     * @return List of Type data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Type> findTypeByIdType(java.lang.Integer idType) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified name field.
     *
     * @param name the field
     * @return List of Type data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Type> findTypeByName(java.lang.String name) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified description field.
     *
     * @param description the field
     * @return List of Type data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.Type> findTypeByDescription(java.lang.String description) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;


}
