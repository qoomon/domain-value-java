package com.qoomon.domainvalue.type;

import com.qoomon.domainvalue.common.Id;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by qoomon on 03/08/15.
 */
public class IdTest {

    @Test(expected = AssertionError.class)
    public void of_invalid() throws Exception {
        // GIVEN

        // WHEN
        Id.of(-1L);

        //THEN
    }

    @Test(expected = AssertionError.class)
    public void of_invalid_dv() throws Exception {
        // GIVEN

        // WHEN
        Id.of(null);

        //THEN
    }

    @Test
    public void of_valid() throws Exception {
        // GIVEN

        // WHEN
        Id id = Id.of(123456789L);

        //THEN
        assertThat(id.value(), is(123456789L));
    }
}