package sust.classnotfound.touristfriend.session;

/**
 * The <code>UserServiceService</code> bean exposes the business methods in the interface.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.11 $, $Date: 2006/04/29 12:39:09 $
 */
public interface IUserService {

   /*******************************************************************************************************************
    *                                  B U S I N E S S   M E T H O D S
    *******************************************************************************************************************/


   /*******************************************************************************************************************
    *                                  P E R S I S T E N C E    M E T H O D S
    *******************************************************************************************************************/

   /**
    * Adds a new user to the storage.
    *
    * @param model a data object
    * @return User a data object with the primary key
    */
   sust.classnotfound.touristfriend.entity.User addUser(sust.classnotfound.touristfriend.entity.User model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Stores the <code>User</code>.
    *
    * @param model the data model to store
    */
   void saveUser(sust.classnotfound.touristfriend.entity.User model) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Removes a user.
    *
    * @param id the unique reference for the user
    */
   void deleteUser(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Retrieves a data object from the storage by its primary key.
    *
    * @param id the unique reference
    * @return User the data object
    */
   sust.classnotfound.touristfriend.entity.User getUser(java.lang.Integer id) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a list of all user instances.
    *
    * @return a list of User objects.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.User> getUserList() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Returns a subset of all user instances.
    *
    * @param startIndex the start index within the result set (1 = first record);
    * any zero/negative values are regarded as 1, and any values greater than or equal to
    * the total number of user instances will simply return an empty set.
    * @param endIndex the end index within the result set (<code>getUserListSize()</code> = last record),
    * any values greater than or equal to the total number of user instances will cause
    * the full set to be returned.
    * @return a collection of User objects, of size <code>(endIndex - startIndex)</code>.
    * throws GenericBusinessException if the chosen underlying data-retrieval mechanism does not support returning partial result sets.
    */
   java.util.List<sust.classnotfound.touristfriend.entity.User> getUserList(int startIndex, int endIndex) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

   /**
    * Obtains the total number of user objects in the storage.
    * <b>NOTE:</b>If this session fa�ade is configured <b>not</b> to use the FastLaneReader,
    * this call will be very computationally wasteful as it will first have to retrieve all entities from
    * the entity bean's <code>findAll</code> method.
    *
    * @return an integer value.
    */
   int getUserListSize() throws sust.classnotfound.touristfriend.exception.GenericBusinessException;

    /**
     *
     * Retrieves a list of data object for the specified idUser field.
     *
     * @param idUser the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.User> findUserByIdUser(java.lang.Integer idUser) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userId field.
     *
     * @param userId the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.User> findUserByUserId(java.lang.Integer userId) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified userName field.
     *
     * @param userName the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.User> findUserByUserName(java.lang.String userName) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified email field.
     *
     * @param email the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.User> findUserByEmail(java.lang.String email) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified address field.
     *
     * @param address the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.User> findUserByAddress(java.lang.String address) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified validity field.
     *
     * @param validity the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.User> findUserByValidity(java.lang.String validity) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified sex field.
     *
     * @param sex the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.User> findUserBySex(java.lang.String sex) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified dob field.
     *
     * @param dob the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.User> findUserByDob(java.sql.Date dob) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;
    /**
     *
     * Retrieves a list of data object for the specified idType field.
     *
     * @param idType the field
     * @return List of User data objects, empty list in case no results were found.
     */
    java.util.List<sust.classnotfound.touristfriend.entity.User> findUserByIdType(java.lang.Integer idType) throws sust.classnotfound.touristfriend.exception.GenericBusinessException;


}
