package twq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.twq"})
@ComponentScan("com.twq")
public class FeignDeptConsumer_feign_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_feign_80.class,args);
    }
}
