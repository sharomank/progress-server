package com.sharomank.progress.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ReflectionUtils;

public final class JavaBeanUtils {
    private JavaBeanUtils() {
    }

    public static void copyNotNullProperties(Object source, Object target) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        final BeanWrapper trg = new BeanWrapperImpl(target);
        ReflectionUtils.doWithFields(source.getClass(), field -> {
            String propName = field.getName();
            Object srcPropValue = src.getPropertyValue(propName);
            if (srcPropValue != null) {
                trg.setPropertyValue(propName, srcPropValue);
            }
        });
    }
}