package me.fpoblete;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WorldTest {

    private int size;
    private World world;

    @Before
    public void setUp() {
        size = 4;
        world = new World(size, true);
    }

    @Test
    public void aWorldOf4x4ShouldExistWhenCreatingANewGameWith4AsTheSize() throws Exception {
        Assert.assertEquals(size, world.countRows());
        Assert.assertEquals(size, world.countColumns());
    }

    @Test
    public void aNewWorldShouldHaveAtLeastOneIndividual() throws Exception {
        Assert.assertNotEquals(0, world.countIndividuals());
    }

    @Test
    public void anInvidivualShouldDieOfOverPopulationWhenItHasMoreThanThreeNeighboors() throws Exception {
        boolean[][] matrix =    {{true,true,false,false},
                                 {true,true,false,false},
                                 {true,false,false,false},
                                 {false,false,false,false}};

        world.setMatrix(matrix);

        assertFalse(world.willBeAlive(1,1));
    }

    @Test
    public void anInvidivualShouldDieOfUnderPopulationWhenItHasLessThanTwoNeighboors() throws Exception {
        boolean[][] matrix =    {{true,false,false,false},
                {false,false,false,false},
                {false,false,false,false},
                {false,false,false,false}};

        world.setMatrix(matrix);

        assertFalse(world.willBeAlive(0,0));
    }


    @Test
    public void anInvidivualShouldLiveWhenItHasTwoNeighboors() throws Exception {
        boolean[][] matrix =    {{true,true,false,false},
                                 {true,false,false,false},
                                 {false,false,false,false},
                                 {false,false,false,false}};

        world.setMatrix(matrix);

        assertTrue(world.willBeAlive(0,0));
    }

    @Test
    public void anInvidivualShouldLiveWhenItHasThreeNeighboors() throws Exception {
        boolean[][] matrix =    {{true,true,false,false},
                                 {true,true,false,false},
                                 {false,false,false,false},
                                 {false,false,false,false}};

        world.setMatrix(matrix);

        assertTrue(world.willBeAlive(1,1));
    }

    @Test
    public void aNewIndividualShouldNotBeBornUnlessTheCellHasThreeNeighboors() throws Exception {
        boolean[][] matrix =    {{true,true,false,false},
                                 {true,true,false,false},
                                 {false,false,false,false},
                                 {false,false,false,false}};

        world.setMatrix(matrix);

        assertFalse(world.willBeAlive(0,2));

    }

    @Test
    public void aNewIndividualShouldBeBornWhenTheCellHasThreeNeighboors() throws Exception {
        boolean[][] matrix =    {{true,true,false,false},
                                 {true,false,false,false},
                                 {false,false,false,false},
                                 {false,false,false,false}};

        world.setMatrix(matrix);

        assertTrue(world.willBeAlive(1,1));

    }

    @Test
    public void shouldPrintSpaceForDeadCellsAndXForLiveCells() throws Exception {
        WorldBuilder worldBuilder = new WorldBuilder(4);
        worldBuilder.withIndividual(0,0);
        worldBuilder.withIndividual(0,1);
        worldBuilder.withIndividual(0,2);
        World game = worldBuilder.build();

        Assert.assertEquals("OOO.\n....\n....\n....\n", game.toString());
    }

    @Test
    public void shouldCalculateTheCorrectNextGeneration() throws Exception {

        WorldBuilder worldBuilder = new WorldBuilder(4);
        World world = worldBuilder.build();
        world.nextGeneration();
        Assert.assertEquals(0, world.countIndividuals());

        worldBuilder.withIndividual(0,0);
        worldBuilder.withIndividual(0,1);
        world = worldBuilder.build();
        world.nextGeneration();
        Assert.assertEquals(0, world.countIndividuals());

        worldBuilder.withIndividual(0,0);
        worldBuilder.withIndividual(0,1);
        worldBuilder.withIndividual(0,2);
        world = worldBuilder.build();
        world.nextGeneration();
        Assert.assertEquals(2, world.countIndividuals());

        worldBuilder.withIndividual(0,0);
        worldBuilder.withIndividual(0,1);
        worldBuilder.withIndividual(0,2);
        worldBuilder.withIndividual(1,0);
        worldBuilder.withIndividual(1,1);
        worldBuilder.withIndividual(1,2);
        world = worldBuilder.build();
        world.nextGeneration();
        Assert.assertEquals(5, world.countIndividuals());


    }


}
