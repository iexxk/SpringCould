package exxk.could.ribbonrest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError") //调用发生错误就调用hiError方法
    public String hiService(String name){
        //eureka-client为服务提供者的spring.application.name=eureka-client
       return restTemplate.getForObject("http://eureka-client/hi?name="+name,String.class);
    }
    //发生错误调用的方法
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
