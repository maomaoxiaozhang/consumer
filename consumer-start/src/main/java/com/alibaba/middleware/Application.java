package com.alibaba.middleware;

import com.alibaba.middleware.diamond.DiamondDemo;
import com.alibaba.middleware.hsf.HelloService;
import com.alibaba.middleware.hsf.consumer.HsfConsumer;
import com.alibaba.middleware.metaq.MessageSender;
import com.alibaba.middleware.tair.TairProperties;
import com.alibaba.middleware.tddl.Salary;
import com.alibaba.middleware.tddl.jdbc.JdbcQueryDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.taobao.pandora.boot.PandoraBootstrap;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Pandora Boot应用的入口类
 * <p>
 * 详情见http://gitlab.alibaba-inc.com/middleware-container/pandora-boot/wikis/spring-boot-diamond
 *
 * @author chengxu
 */
@SpringBootApplication(scanBasePackages = {"com.alibaba.middleware"})
public class Application {

    public static void main(String[] args) throws Exception {
        PandoraBootstrap.run(args);
        ApplicationContext context = SpringApplication.run(Application.class, args);

        //tair
        TairProperties properties = (TairProperties) context.getBean("tairProperties");
        properties.put(1, "name", "shouchang");
        properties.put(2, "value", "true");
        String sql = properties.get(1, "name");
        String value = properties.get(2, "value");
        if (value.equals("true")) {
            //diamond
            DiamondDemo demo = (DiamondDemo) context.getBean("diamondDemo");
            System.err.println(demo);
        }
        //hsf
        HsfConsumer consumer = (HsfConsumer) context.getBean("hsfConsumer");
        HelloService service = consumer.service;
        String hsfResult = service.getSql(sql);
        System.out.println(hsfResult);
        //tddl
        JdbcQueryDemo queryDemo = (JdbcQueryDemo) context.getBean("jdbcQueryDemo");
        List<Salary> tddlResult = queryDemo.query(hsfResult);
        //metaq
        MessageSender messageSender = context.getBean(MessageSender.class);
        for (Salary salary : tddlResult) {
            messageSender.sendMessage(salary.toString());
        }

        PandoraBootstrap.markStartupAndWait();
    }
}
