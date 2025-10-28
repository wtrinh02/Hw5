package Proxy;

public class ProxyService {

    private RealService service;

    public ProxyService(RealService service){
        this.service = service;
    }
    
}
