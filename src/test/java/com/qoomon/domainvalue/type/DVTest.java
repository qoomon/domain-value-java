package com.qoomon.domainvalue.type;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import com.qoomon.domainvalue.exception.InvalidValueException;
import com.qoomon.domainvalue.exception.MethodMissingException;

/**
 * Created by qoomon on 03/08/15.
 */
public class DVTest {

    @BeforeClass
    public static void beforeClass() {
        DV.validateOnConstruction(true);
    }

    @Test
    public void of_valid() throws Exception {
        // GIVEN

        // WHEN
        ValidLongDV testLongDV = DV.of(ValidLongDV.class, 1L);

        // THEN
        assertThat(testLongDV, is(not(nullValue())));
    }

    @Test(expected = InvalidValueException.class)
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
        DV.ensureInterface(ValidLongDV.class);

        // THEN
    }

    @Test(expected = MethodMissingException.class)
    public void ensureInterface_invalidDV_ofMehtod_notPresent() throws Exception {
        // GIVEN

        // WHEN
        DV.ensureInterface(InvalidLongDV_ofMehtod_notPresent.class);

        // THEN
    }

    @Test(expected = MethodMissingException.class)
    public void ensureInterface_invalidDV_ofMehtod_wrongParameter() throws Exception {
        // GIVEN

        // WHEN
        DV.ensureInterface(InvalidLongDV_ofMehtod_wrongParameter.class);

        // THEN
    }

    @Test(expected = MethodMissingException.class)
    public void ensureInterface_invalidDV_ofMehtod_notPublic() throws Exception {
        // GIVEN

        // WHEN
        DV.ensureInterface(InvalidLongDV_ofMehtod_notPublic.class);

        // THEN
    }

    @Test(expected = MethodMissingException.class)
    public void ensureInterface_invalidDV_ofMehtod_wrongReturnType() throws Exception {
        // GIVEN

        // WHEN
        new InvalidLongDV_ofMehtod_wrongReturnType(1L);
        DV.ensureInterface(InvalidLongDV_ofMehtod_wrongReturnType.class);

        // THEN
    }

    @Test(expected = MethodMissingException.class)
    public void ensureInterface_invalidDV_isValidMethod_notPresent() throws Exception {
        // GIVEN

        // WHEN
        DV.ensureInterface(InvalidLongDV_invalidDV_isValidMethod_notPresent.class);

        // THEN
    }

    public static class ValidLongDV extends LongDV {

        protected ValidLongDV(Long value) {
            super(value);
        }

        public static ValidLongDV of(Long value) {
            return new ValidLongDV(value);
        }

        public static boolean isValid(Long value) {
            return LongDV.isValid(value);
        }
    }

    public static class InvalidLongDV_ofMehtod_notPresent extends LongDV {

        protected InvalidLongDV_ofMehtod_notPresent(Long value) {
            super(value);
        }

        public static boolean isValid(Long value) {
            return LongDV.isValid(value);
        }
    }

    public static class InvalidLongDV_ofMehtod_wrongParameter extends LongDV {

        protected InvalidLongDV_ofMehtod_wrongParameter(Long value) {
            super(value);
        }

        public static InvalidLongDV_ofMehtod_wrongParameter of(Integer value) {
            return new InvalidLongDV_ofMehtod_wrongParameter(Long.valueOf(value));
        }

        public static boolean isValid(Long value) {
            return LongDV.isValid(value);
        }
    }

    public static class InvalidLongDV_ofMehtod_notPublic extends LongDV {

        protected InvalidLongDV_ofMehtod_notPublic(Long value) {
            super(value);
        }

        static InvalidLongDV_ofMehtod_notPublic of(Long value) {
            return new InvalidLongDV_ofMehtod_notPublic(value);
        }

        public static boolean isValid(Long value) {
            return LongDV.isValid(value);
        }
    }

    public static class InvalidLongDV_ofMehtod_wrongReturnType extends LongDV {

        protected InvalidLongDV_ofMehtod_wrongReturnType(Long value) {
            super(value);
        }

        public static Long of(Long value) {
            return value;
        }

        public static boolean isValid(Long value) {
            return LongDV.isValid(value);
        }
    }

    public static class InvalidLongDV_invalidDV_isValidMethod_notPresent extends LongDV {

        protected InvalidLongDV_invalidDV_isValidMethod_notPresent(Long value) {
            super(value);
        }

        public static InvalidLongDV_invalidDV_isValidMethod_notPresent of(Long value) {
            return new InvalidLongDV_invalidDV_isValidMethod_notPresent(value);
        }
    }

    public static class InvalidLongDV_isValidMehtod_wrongParameter extends LongDV {

        protected InvalidLongDV_isValidMehtod_wrongParameter(Long value) {
            super(value);
        }

        public static InvalidLongDV_isValidMehtod_wrongParameter of(Long value) {
            return new InvalidLongDV_isValidMehtod_wrongParameter(value);
        }

        public static boolean isValid(Long value) {
            return LongDV.isValid(value);
        }
    }

}