package me.fpoblete;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Test
    public void shouldCountZeroNeighboors() throws Exception {

        boolean[][] matrix =    {{true,false,false,false},
                                 {false,false,false,false},
                                 {false,false,false,false},
                                 {false,false,false,false}};

        Assert.assertEquals(0, Utils.countFor(matrix, 0,0));

    }

    @Test
    public void shouldCountTwoNeighboors() throws Exception {

        boolean[][] matrix =    {{true,true,false,false},
                                 {true,false,false,false},
                                 {false,false,false,false},
                                 {false,false,false,false}};


        Assert.assertEquals(2, Utils.countFor(matrix, 0,0));

    }
}