package kr.rlog.batch;

import kr.rlog.batch.common.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@ServletComponentScan
@SpringBootApplication
@EnableJpaAuditing
@Slf4j
public class Application {

    // 웹 프로그램처럼 항상 돌리지는 않음 ~> exit
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        log.info(MessageUtils.getMessage("batch.end"));
        System.exit(SpringApplication.exit(context));
    }
}
