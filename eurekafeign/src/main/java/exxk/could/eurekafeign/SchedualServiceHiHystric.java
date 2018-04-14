package exxk.could.eurekafeign;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements FeignSchedualService{
    @Override
    public String sayHiFromEurekaClient(String name) {
        return "sorry "+name;
    }
}
