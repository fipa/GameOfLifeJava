package me.fpoblete;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LineCoverageTest {

    @Test
    public void constructorTestWithOneInteger() throws Exception {

        World world = new World(5);

        assertNotNull(world);
    }

    @Test
    public void constructorTestWithOneIntegerAndOneBoolean() throws Exception {

        World world = new World(5, true);

        assertNotNull(world);
    }

    @Test
    public void constructorTestWithTwoIntegers() throws Exception {

        World world = new World(5,5);

        assertNotNull(world);
    }

    @Test
    public void constructorTestWithTwoIntegersAndOneBoolean() throws Exception {

        World world = new World(5,5, true);

        assertNotNull(world);
    }

    @Test
    public void nextGenerationTest() throws Exception {

        World world = new World(10, true);

        world.nextGeneration();

    }

    @Test
    public void countIndividuals() throws Exception {

        World world = new World(10);

        assertEquals(0, world.countIndividuals());

    }

    @Test
    public void toStringTest() throws Exception {

        World world = new World(10, true);

        world.toString();

    }

    @Test
    public void testOtherMethods() throws Exception {

        World world = new World(10);
        world.setAlive(0,0);
        world.setMatrix(null);

    }
}