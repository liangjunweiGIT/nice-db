package com.rongda.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author Created by junwei.liang on 2019/5/22 19:29
 */
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        assertApplicationContext();
        return applicationContext;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) {
        assertApplicationContext();
        return (T) applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> requiredType) {
        assertApplicationContext();
        return applicationContext.getBean(requiredType);
    }

    private static void assertApplicationContext() {
        if (SpringContextHolder.applicationContext == null) {
            throw new RuntimeException("applicaitonContext属性为null,请检查是否注入了SpringContextHolder!");
        }
    }

    public static <T> List<T> getBeans(Class<T> type) {
        Map<String, T> beanMape = getBeansByType(type);
        return new ArrayList<>(beanMape.values());
    }

    public static <T> Map<String, T> getBeansByType(Class<T> type) {
        return BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext, type);
    }

    public static Set<String> getBeanKeyByType(Class<?> type) {
        return getBeansByType(type).keySet();
    }

    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) {
        Map<String, Object> map1 = new HashMap<String, Object>(0);

        if (applicationContext != null) {
            map1 = applicationContext.getBeansWithAnnotation(annotationType);
        }

        Map<String, Object> result = new HashMap<String, Object>(map1.size());
        result.putAll(map1);
        return result;
    }

    public static boolean containsBean(String id) {
        return applicationContext.containsBean(id);
    }

}