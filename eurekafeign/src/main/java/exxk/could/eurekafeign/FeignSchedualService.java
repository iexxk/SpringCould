package exxk.could.eurekafeign;

        import org.springframework.cloud.openfeign.FeignClient;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",fallback = SchedualServiceHiHystric.class) //指定调用那个服务（服务名spring.application.name）
public interface FeignSchedualService {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)  //指定调用eureka-client服务的那个接口
    String sayHiFromEurekaClient(@RequestParam(value = "name") String name);
}
