package cn.dmai.frame;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author linchengdong
 * @Date 2023-11-29 13:40
 * @PackageName:cn.dmai.frame
 * @ClassName: Application
 * @Description: TODO
 * @Version 1.0
 */
@SpringBootApplication
@Configurable
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
