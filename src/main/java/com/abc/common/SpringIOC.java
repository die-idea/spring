package com.abc.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIOC {
    public static ApplicationContext getSpringIOC(){
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
