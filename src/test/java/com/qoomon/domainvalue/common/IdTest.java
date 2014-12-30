package com.qoomon.domainvalue.common;

import org.junit.rules.Stopwatch;

import java.util.Random;

public class IdTest {

    @org.junit.Test
    public void testValidate() throws Exception {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100_000_000; i++) {
            Id.validate(1L);
        }
        long endTime = System.nanoTime();

        long duration = (endTime - startTime)/1_000_000;
        System.out.println("validate: "+duration);

    }

    @org.junit.Test
    public void testOf() throws Exception {

        long startTime = System.nanoTime();
        for (int i = 0; i < 100_000_000; i++) {
            Id.of(1L);
        }
        long endTime = System.nanoTime();

        long duration = (endTime - startTime)/1_000_000;
        System.out.println("of: "+duration);

    }

}