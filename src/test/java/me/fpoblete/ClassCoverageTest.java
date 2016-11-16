package me.fpoblete;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassCoverageTest {

    @Test
    public void worldTest() throws Exception {

        World world = new World(5);

        assertNotNull(world);
    }
}