package internet.star.union.cheat.api.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 启动api服务的主入口
 */
@SpringBootApplication
@ComponentScan({"internet.star.union.cheat.api.controller",
        "internet.star.union.cheat.api.service",
        "internet.star.union.cheat.api.dao",
        "internet.star.union.cheat.api.beans",
        "internet.star.union.cheat.api.scheduled"})
@EnableAutoConfiguration
@EnableScheduling
public class TestApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(TestApplication.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        List<RedisTemplate<String, String>> redisTemplates = (List<RedisTemplate<String, String>>) ctx.getBean("wRedisTemplates");
        RedisTemplate<String, String> template = redisTemplates.get(0);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {



            String key = "test" + i;
            String hKey = "name";
            String value = "name" + i;
//            template.
            template.opsForHash().put(key, hKey, value);
            template.expire(key, 1, TimeUnit.DAYS);
            hKey = "age";
            value = "age" + i;
            template.opsForHash().put(key, hKey, value);
            template.expire(key, 1, TimeUnit.DAYS);



        }
        long end = System.currentTimeMillis();
        System.out.println(start-end);


    }

}