package sust.classnotfound.touristfriend.servicelocator;

import sust.classnotfound.touristfriend.exception.*;

/**
 * Interface that determines the service.
 *
 * @author  ClassNotFound_Team  Finalist IT Group
 * @version $Revision: 1.1 $, $Date: 2005/10/13 21:17:51 $
 */
public interface ServiceInfo {
    /**
     * determine service.
     * @return Locatable Service
     * @throws ServiceInstantiationException service can not be started.
     * @throws UnknownServiceException Unknown service
     */
    LocatableService getService() throws ServiceInstantiationException, UnknownServiceException;
}
