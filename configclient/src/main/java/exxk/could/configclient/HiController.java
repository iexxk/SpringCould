package exxk.could.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RefreshScope
@RestController
public class HiController {
    @Value("${test}") //调用配置中心的配置
            String test;

    @Value("${common}") //调用配置中心的配置
            String common;

    @RequestMapping(value = "/hi")
    public List<String> hi() {
        return Arrays.asList(test, common);
    }
}
