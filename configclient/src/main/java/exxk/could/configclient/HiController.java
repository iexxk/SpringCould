package exxk.could.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class HiController {
    @Value("${test}") //调用配置中心的配置
    String test;

    @RequestMapping(value = "/hi")
    public String hi(){
        return test;
    }
}
