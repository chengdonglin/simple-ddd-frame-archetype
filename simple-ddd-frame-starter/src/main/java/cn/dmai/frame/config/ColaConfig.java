package cn.dmai.frame.config;

import com.alibaba.cola.boot.SpringBootstrap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author linchengdong
 * @Date 2023-11-29 16:02
 * @PackageName:cn.dmai.frame.config
 * @ClassName: ColaConfig
 * @Description: COLA框架的配置
 * @Version 1.0
 */
@Configuration
@ComponentScan(value = {"com.alibaba.cola"})
public class ColaConfig {


    @Bean(initMethod = "init")
    public SpringBootstrap bootstrap() {
        return new SpringBootstrap();
    }
}
