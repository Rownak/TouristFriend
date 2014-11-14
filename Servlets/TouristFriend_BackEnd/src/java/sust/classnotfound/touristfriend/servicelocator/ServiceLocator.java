package sust.classnotfound.touristfriend.servicelocator;

import sust.classnotfound.touristfriend.exception.*;
import sust.classnotfound.touristfriend.session.*;
import sust.classnotfound.touristfriend.session.*;
import sust.classnotfound.touristfriend.session.*;
import sust.classnotfound.touristfriend.session.*;
import sust.classnotfound.touristfriend.session.*;
import sust.classnotfound.touristfriend.session.*;
import sust.classnotfound.touristfriend.session.*;
import sust.classnotfound.touristfriend.session.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import com.finalist.util.log.LogService;
import com.finalist.util.log.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


/**
 * The Service Locator maps an interface to an implementation.
 * See:
 * http://java.sun.com/blueprints/corej2eepatterns/Patterns/ServiceLocator.html
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.3 $, $Date: 2006/01/29 21:26:04 $
 */
public class ServiceLocator {
    /**
     * the logger.
     */
    private static Logger log = LogService.getLogger(ServiceLocator.class);

    /**
     * The DatabaseSessionService name.
     */
    public static final String DATABASE_SESSION_SERVICE = "DATABASE_SESSION_SERVICE";



    /**
     * The DistrictServiceService name.
     */
    public static final String DISTRICTSERVICE_SERVICE = "DISTRICTSERVICE_SERVICE";

    /**
     * The LocationServiceService name.
     */
    public static final String LOCATIONSERVICE_SERVICE = "LOCATIONSERVICE_SERVICE";

    /**
     * The PhotosServiceService name.
     */
    public static final String PHOTOSSERVICE_SERVICE = "PHOTOSSERVICE_SERVICE";

    /**
     * The PlaceServiceService name.
     */
    public static final String PLACESERVICE_SERVICE = "PLACESERVICE_SERVICE";

    /**
     * The RatingMappingServiceService name.
     */
    public static final String RATINGMAPPINGSERVICE_SERVICE = "RATINGMAPPINGSERVICE_SERVICE";

    /**
     * The SeasonServiceService name.
     */
    public static final String SEASONSERVICE_SERVICE = "SEASONSERVICE_SERVICE";

    /**
     * The TypeServiceService name.
     */
    public static final String TYPESERVICE_SERVICE = "TYPESERVICE_SERVICE";

    /**
     * The UserServiceService name.
     */
    public static final String USERSERVICE_SERVICE = "USERSERVICE_SERVICE";

    /**
     * Contains the class constants
     */
    private static HashMap map;

    /**
     * Contains the classname of the implementation class.
     */
    private static Map serviceInfoMap;

    /**
     * Contains the interface name of the service.
     */
    private static Map serviceInterfaceMap;

    /**
     * Contains the instantiated services.
     */
    private static Map serviceMap;

    /**
     * property.
     */
    static Properties props = null;

    /**
     * Read the service properties.
     */
    static {
        props = ServicePropertyReader.getProperties();
        serviceInfoMap = new HashMap();
        serviceMap = new HashMap();
        serviceInterfaceMap = new HashMap();

        serviceInfoMap.put(DATABASE_SESSION_SERVICE,
                           props.getProperty(DATABASE_SESSION_SERVICE));
        serviceInfoMap.put(DISTRICTSERVICE_SERVICE,
                           props.getProperty(DISTRICTSERVICE_SERVICE));

        serviceInfoMap.put(LOCATIONSERVICE_SERVICE,
                           props.getProperty(LOCATIONSERVICE_SERVICE));

        serviceInfoMap.put(PHOTOSSERVICE_SERVICE,
                           props.getProperty(PHOTOSSERVICE_SERVICE));

        serviceInfoMap.put(PLACESERVICE_SERVICE,
                           props.getProperty(PLACESERVICE_SERVICE));

        serviceInfoMap.put(RATINGMAPPINGSERVICE_SERVICE,
                           props.getProperty(RATINGMAPPINGSERVICE_SERVICE));

        serviceInfoMap.put(SEASONSERVICE_SERVICE,
                           props.getProperty(SEASONSERVICE_SERVICE));

        serviceInfoMap.put(TYPESERVICE_SERVICE,
                           props.getProperty(TYPESERVICE_SERVICE));

        serviceInfoMap.put(USERSERVICE_SERVICE,
                           props.getProperty(USERSERVICE_SERVICE));

        serviceInterfaceMap.put(DATABASE_SESSION_SERVICE,
                           "sust.classnotfound.touristfriend.DatabaseSessionService");

        serviceInterfaceMap.put(DISTRICTSERVICE_SERVICE,
                           "sust.classnotfound.touristfriend.session.IDistrictService");
        serviceInterfaceMap.put(LOCATIONSERVICE_SERVICE,
                           "sust.classnotfound.touristfriend.session.ILocationService");
        serviceInterfaceMap.put(PHOTOSSERVICE_SERVICE,
                           "sust.classnotfound.touristfriend.session.IPhotosService");
        serviceInterfaceMap.put(PLACESERVICE_SERVICE,
                           "sust.classnotfound.touristfriend.session.IPlaceService");
        serviceInterfaceMap.put(RATINGMAPPINGSERVICE_SERVICE,
                           "sust.classnotfound.touristfriend.session.IRatingMappingService");
        serviceInterfaceMap.put(SEASONSERVICE_SERVICE,
                           "sust.classnotfound.touristfriend.session.ISeasonService");
        serviceInterfaceMap.put(TYPESERVICE_SERVICE,
                           "sust.classnotfound.touristfriend.session.ITypeService");
        serviceInterfaceMap.put(USERSERVICE_SERVICE,
                           "sust.classnotfound.touristfriend.session.IUserService");

    }

    /**
     * Locate a Service implementation by passing the Name of the service. The
     * getService() method will initalize an implementation of the service.
     *
     * @param serviceName de naam van de service
     * @return Een Implementatie van de gespecificeerde service.
     * @throws UnknownServiceException de exceptie
     * @throws ServiceInstantiationException de exceptie
     */
    public static LocatableService getService(String serviceName)
                                       throws UnknownServiceException,
                                              ServiceInstantiationException {
        log.debug("Locating service for " + serviceName);

        //see if there is a initialized
        LocatableService service = (LocatableService) serviceMap.get(serviceName);

        if (service != null) {
            return service;
        } else {
            //get service for the first time
            String className = (String) serviceInfoMap.get(serviceName);
            log.debug("Found service " + className);
            String interfaceName = (String) serviceInterfaceMap.get(serviceName);
            log.debug("Found service " + interfaceName);

            if (className != null) {
                try {
                    log.debug("Use classloader to find class: " + interfaceName);
                    Class theServiceInterface = Class.forName(interfaceName);
                    log.debug("Use classloader to find class: " + className);                    
                    Class theDelegateClass = Class.forName(className);
   					  log.debug("Create a new instance of the loaded class.");
						  try {
                        log.debug("Create a new instance of the loaded class.");
                        service = (LocatableService) theDelegateClass.newInstance();
                    } catch (Exception e) {
                        log.debug("Create a dynamic proxy for the loaded class.");
                        service = (LocatableService) Proxy.newProxyInstance(theServiceInterface.getClassLoader(), new Class[]{theServiceInterface, LocatableService.class}, (InvocationHandler) theDelegateClass.newInstance());
                    }
                    service.init();
                    log.debug("The service was initialized");
                    serviceMap.put(serviceName, service);
                    log.debug("The service was put in the map");

                    return service;
                } catch (Exception e) {
                    log.error("Error instantiating the service", e);
                    throw new ServiceInstantiationException(e);
                }
            }

            throw new UnknownServiceException("Service not found:" + serviceName);
        }
    }
   /**
    * Determines a list of all constants using reflection and put them in a hashmap.
    *
    * @return HashMap with the names of all constants and their String values.
    */
   public synchronized static HashMap getConstants() {
      if (map != null) {
         return map;
      }
      map = new HashMap();
      Field fields[] = null;

      try {
         fields = ServiceLocator.class.getDeclaredFields();
      }
      catch (SecurityException e) {
         e.printStackTrace();
         return new HashMap();
      }
      if (fields != null) {
         if (fields.length != 0) {
            for (int i = 0; i < fields.length; i++) {
               if (Modifier.isPublic(fields[i].getModifiers())
                  && Modifier.isFinal(fields[i].getModifiers())
                  && Modifier.isStatic(fields[i].getModifiers())
               ) {
                  // It's a constant!
                  try {
                     map.put(fields[i].getName(), fields[i].get(null));
                  }
                  catch (Exception e) {
                     e.printStackTrace();
                     return new HashMap();
                  }
               }
            }
         }
      }
      return map;
   }
}
