package com.pixelus.hystrix;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableHystrix
public class HystrixConfiguration {

    @Autowired
    private HystrixProperties hystrixProperties;

    @Bean
    @ConditionalOnClass(HystrixCommandAspect.class)
    @ConditionalOnExpression("${hystrix.enabled:false}")
    public HystrixCommandAspect hystrixCommandAspect() {
        return new HystrixCommandAspect();
    }

    @Bean
    @ConditionalOnClass(HystrixMetricsStreamServlet.class)
    @ConditionalOnExpression("${hystrix.streamEnabled:false}")
    public ServletRegistrationBean hystrixStreamServlet() {
        return new ServletRegistrationBean(new HystrixMetricsStreamServlet(), hystrixProperties.getStreamUrl());
    }
}

