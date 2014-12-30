package com.qoomon.domainvalue.type;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qoomon on 30/12/14.
 */
public class DVUtil {

    private static Map<Class<?>, Constructor<?>> CONSTRUCTOR_CACHE = new HashMap<>();

    /**
     * @param dvType domain value type
     * @return a new DV instance
     */
    public static <V, T extends DV<V>> Constructor<T> getConstructor(Class<V> valueType, Class<T> dvType) {
        try {
            Constructor<T> dvConstructor = (Constructor<T>) CONSTRUCTOR_CACHE.get(dvType);
            if (dvConstructor == null) {
                dvConstructor = dvType.getDeclaredConstructor(valueType);
                dvConstructor.setAccessible(true);
                CONSTRUCTOR_CACHE.put(dvType, dvConstructor);
            }
            return dvConstructor;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param value  to wrap
     * @param dvType domain value type
     * @return a new DV instance
     */
    public static <V, T extends DV<V>> T newInstance(V value, Class<V> valueType, Class<T> dvType) {
        try {
            Constructor<T> constructor = getConstructor(valueType, dvType);
            return constructor.newInstance(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param value  to wrap
     * @param dvType domain value type
     * @return true if value is not null, false else
     */
    public static <V, T extends DV<V>> boolean validate(V value, Class<V> valueType, Class<T> dvType) {
        T dv = newInstance(null, valueType, dvType);
        return dv.isValid(value);
    }

    /**
     * @param value  to wrap
     * @param dvType domain value type
     * @return a DV instance
     */
    public static <V, T extends DV<V>> T of(V value, Class<V> valueType, Class<T> dvType) {
        assert validate(value, valueType, dvType) : value + " is not a valid value for " + dvType.getClass().getSimpleName();
        return newInstance(value, valueType, dvType);
    }

}
