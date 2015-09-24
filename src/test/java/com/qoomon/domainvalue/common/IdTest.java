package com.qoomon.domainvalue.common;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import com.qoomon.domainvalue.exception.InvalidValueException;
import com.qoomon.domainvalue.type.DV;

/**
 * Created by qoomon on 03/08/15.
 */
public class IdTest {

    @BeforeClass
    public static void beforeClass() {
        DV.validateOnConstruction(true);
    }

    @Test(expected = InvalidValueException.class)
    public void of_invalid() throws Exception {
        // GIVEN

        // WHEN
        Id.of(-1L);

        // THEN
    }

    @Test(expected = InvalidValueException.class)
    public void of_invalid_null() throws Exception {
        // GIVEN

        // WHEN
        Id.of(null);

        // THEN
    }

    @Test
    public void of_valid() throws Exception {
        // GIVEN

        // WHEN
        Id id = Id.of(123456789L);

        // THEN
        assertThat(id.value(), equalTo(123456789L));
    }

}