package service;

public class ServiceFactory {
    private static IService service;
    public static IService getService(){
        return service;
    }
    public static void setService(IService service){
        ServiceFactory.service = service;
    }
}
