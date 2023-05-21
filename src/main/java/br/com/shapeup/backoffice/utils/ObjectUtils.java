package br.com.shapeup.backoffice.utils;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class ObjectUtils {

    public static <S, T> T copyNonNullProperties(S source, T target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));

        return target;
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
}
