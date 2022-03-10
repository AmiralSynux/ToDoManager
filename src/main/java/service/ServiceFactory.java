package service;

public class ServiceFactory {
    private static IService service;
    public static IService getService(){
        return service;
    }
    public void setService(IService service){
        ServiceFactory.service = service;
    }
}
