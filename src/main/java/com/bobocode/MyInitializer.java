package com.bobocode;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class MyInitializer implements ServletContainerInitializer {
    public static final String SPRING_APP_CONTEXT = "SPRING_APP_CONTEXT";

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) {
        System.out.println("Init my MyApplicationContext");
        ctx.setAttribute(SPRING_APP_CONTEXT, new AnnotationConfigApplicationContext(AppConfig.class));

    }
}
