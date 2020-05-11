package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.annotation.FactoryMethod;
import com.qoomon.domainvalue.annotation.ValidationMethod;
import com.qoomon.domainvalue.exception.InvalidAnnotationException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by qoomon on 03/08/15.
 */
public class DVTest {

    public static <T extends DV<V>, V> void ensureInterface(Class<T> type, V value) {
        DV.isValid(type, value); // ensure validation method is present
        DV.of(type, value); // ensure of factory method is present
    }

    @Test
    public void of_valid() throws Exception {
        // GIVEN

        // WHEN
        ValidLongDV testLongDV = DV.of(ValidLongDV.class, 1L);

        // THEN
        assertThat(testLongDV, is(not(nullValue())));
    }

    @Test
    public void of_valid_withoutAnnotation() throws Exception {
        // GIVEN

        // WHEN
        ValidLongDV_withoutAnnotations testLongDV = DV.of(ValidLongDV_withoutAnnotations.class, 1L);

        // THEN
        assertThat(testLongDV, is(not(nullValue())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void of_invalid() throws Exception {
        // GIVEN

        // WHEN
        DV.of(ValidLongDV.class, null);

        // THEN
    }

    @Test
    public void isValid_valid() throws Exception {
        // GIVEN

        // WHEN
        boolean isValid = DV.isValid(ValidLongDV.class, 1L);

        // THEN
        assertThat(isValid, is(true));
    }

    @Test
    public void isValid_valid_withoutAnnotation() throws Exception {
        // GIVEN

        // WHEN
        boolean isValid = DV.isValid(ValidLongDV_withoutAnnotations.class, 1L);

        // THEN
        assertThat(isValid, is(true));
    }

    @Test
    public void isValid_invalid() throws Exception {
        // GIVEN

        // WHEN
        boolean isValid = DV.isValid(ValidLongDV.class, null);

        // THEN
        assertThat(isValid, is(false));
    }

    @Test
    public void ensureInterface_validDV() throws Exception {
        // GIVEN

        // WHEN
        ensureInterface(ValidLongDV.class, 1L);

        // THEN
    }

    @Test(expected = NoSuchMethodError.class)
    public void ensureInterface_invalidDV_ofMethod_notPresent() throws Exception {
        // GIVEN

        // WHEN
        ensureInterface(InvalidLongDV_ofMethod_notPresent.class, 1L);

        // THEN
    }

    @Test(expected = NoSuchMethodError.class)
    public void ensureInterface_invalidDV_ofMethod_wrongParameter_factoryMethod() throws Exception {
        // GIVEN

        // WHEN
        DV.of(InvalidLongDV_ofMethod_wrongParameter.class, 1L);
        // THEN
    }

    @Test(expected = NoSuchMethodError.class)
    public void ensureInterface_invalidDV_ofMethod_wrongParameter_validationMethod() throws Exception {
        // GIVEN

        // WHEN
        DV.isValid(InvalidLongDV_ofMethod_wrongParameter.class, 1L);
        // THEN
    }

    @Test(expected = NoSuchMethodError.class)
    public void ensureInterface_invalidDV_ofMethod_notPublic() throws Exception {
        // GIVEN

        // WHEN
        ensureInterface(InvalidLongDV_ofMethod_notPublic.class, 1L);

        // THEN
    }

    @Test(expected = NoSuchMethodError.class)
    public void ensureInterface_invalidDV_ofMethod_wrongReturnType() throws Exception {
        // GIVEN

        // WHEN
        new InvalidLongDV_ofMethod_wrongReturnType(1L);
        ensureInterface(InvalidLongDV_ofMethod_wrongReturnType.class, 1L);

        // THEN
    }

    @Test(expected = NoSuchMethodError.class)
    public void ensureInterface_invalidDV_isValidMethod_notPresent() throws Exception {
        // GIVEN

        // WHEN
        ensureInterface(InvalidLongDV_isValidMethod_notPresent.class, 1L);

        // THEN
    }

    @Test(expected = InvalidAnnotationException.class)
    public void ensureInterface_invalidDV_isValidMethod_ambiguous() throws Exception {
        // GIVEN

        // WHEN
        ensureInterface(InvalidLongDV_isValidMethod_ambiguous.class, 1L);

        // THEN
    }

    public static class ValidLongDV extends LongDV {

        protected ValidLongDV(Long value) {
            super(value);
        }

        @FactoryMethod
        public static ValidLongDV of(Long value) {
            return new ValidLongDV(value);
        }

        @ValidationMethod
        public static boolean isValid(Long value) {
            return LongDV.isValid(value);
        }
    }

    public static class ValidLongDV_withoutAnnotations extends LongDV {

        protected ValidLongDV_withoutAnnotations(Long value) {
            super(value);
        }

        public static ValidLongDV_withoutAnnotations of(Long value) {
            return new ValidLongDV_withoutAnnotations(value);
        }

        public static boolean isValid(Long value) {
            return LongDV.isValid(value);
        }
    }

    public static class InvalidLongDV_ofMethod_notPresent extends LongDV {

        protected InvalidLongDV_ofMethod_notPresent(Long value) {
            super(value);
        }

        @ValidationMethod
        public static boolean isValid(Long value) {
            return LongDV.isValid(value);
        }
    }

    public static class InvalidLongDV_ofMethod_wrongParameter extends LongDV {

        protected InvalidLongDV_ofMethod_wrongParameter(Long value) {
            super(value);
        }

        @FactoryMethod
        public static InvalidLongDV_ofMethod_wrongParameter of(Integer value) {
            return new InvalidLongDV_ofMethod_wrongParameter(value.longValue());
        }

        @ValidationMethod
        public static boolean isValid(Integer value) {
            return LongDV.isValid(value);
        }
    }

    public static class InvalidLongDV_ofMethod_notPublic extends LongDV {

        protected InvalidLongDV_ofMethod_notPublic(Long value) {
            super(value);
        }

        @FactoryMethod
        static InvalidLongDV_ofMethod_notPublic of(Long value) {
            return new InvalidLongDV_ofMethod_notPublic(value);
        }

        @ValidationMethod
        public static boolean isValid(Long value) {
            return LongDV.isValid(value);
        }
    }

    public static class InvalidLongDV_ofMethod_wrongReturnType extends LongDV {

        protected InvalidLongDV_ofMethod_wrongReturnType(Long value) {
            super(value);
        }

        @FactoryMethod
        public static Long of(Long value) {
            return value;
        }

        @ValidationMethod
        public static boolean isValid(Long value) {
            return LongDV.isValid(value);
        }
    }

    public static class InvalidLongDV_isValidMethod_notPresent extends LongDV {

        protected InvalidLongDV_isValidMethod_notPresent(Long value) {
            super(value);
        }

        @ValidationMethod
        public static InvalidLongDV_isValidMethod_notPresent of(Long value) {
            return new InvalidLongDV_isValidMethod_notPresent(value);
        }
    }

    public static class InvalidLongDV_isValidMethod_wrongParameter extends LongDV {

        protected InvalidLongDV_isValidMethod_wrongParameter(Long value) {
            super(value);
        }

        @FactoryMethod
        public static InvalidLongDV_isValidMethod_wrongParameter of(Long value) {
            return new InvalidLongDV_isValidMethod_wrongParameter(value);
        }

        @ValidationMethod
        public static boolean isValid(Long value) {
            return LongDV.isValid(value);
        }
    }

    public static class InvalidLongDV_isValidMethod_ambiguous extends LongDV {

        protected InvalidLongDV_isValidMethod_ambiguous(Long value) {
            super(value);
        }

        @FactoryMethod
        public static InvalidLongDV_isValidMethod_wrongParameter of(Long value) {
            return new InvalidLongDV_isValidMethod_wrongParameter(value);
        }

        @ValidationMethod
        public static boolean isValid1(Long value) {
            return LongDV.isValid(value);
        }

        @ValidationMethod
        public static boolean isValid2(Long value) {
            return LongDV.isValid(value);
        }
    }

}