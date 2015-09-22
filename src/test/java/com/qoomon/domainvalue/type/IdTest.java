package com.qoomon.domainvalue.type;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import com.qoomon.domainvalue.common.Id;
import com.qoomon.domainvalue.exception.DVException;

/**
 * Created by qoomon on 03/08/15.
 */
public class IdTest {

    @BeforeClass
    public static void beforeClass() {
        DV.validateOnConstruction(true);
    }

    @Test(expected = DVException.class)
    public void of_invalid() throws Exception {
        // GIVEN

        // WHEN
        Id.of(-1L);

        // THEN
    }

    @Test(expected = DVException.class)
    public void of_invalid_dv() throws Exception {
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
        assertThat(id.value(), is(123456789L));
    }
}