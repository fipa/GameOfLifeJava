package me.fpoblete;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class WorldFactory {

    public static final String PENTADECATHLON = "Pentadecathlon";
    public static final String GLIDER = "Glider";
    public static final String BEACON = "Beacon";

    static World getPreDefinedWorld(String worldType) {
        if (PENTADECATHLON.equals(worldType)) {
            return buildPentadecathlon();
        } else if (GLIDER.equals(worldType)) {
            return buildGlider();
        } else if (BEACON.equals(worldType)) {
            return buildBeacon();
        }
        else {
            throw new NotImplementedException();
        }
    }

    static World getRandomWorld(int size) {
        return new WorldBuilder().withRandonInvidivuals(size).build();
    }

    private static World buildPentadecathlon() {

        return new WorldBuilder(18, 11)
                .withIndividual(5, 5).withIndividual(5, 6).withIndividual(5, 7)
                .withIndividual(6, 5).withIndividual(6, 7)
                .withIndividual(7, 5).withIndividual(7, 6).withIndividual(7, 7)
                .withIndividual(8, 5).withIndividual(8, 6).withIndividual(8, 7)
                .withIndividual(9, 5).withIndividual(9, 6).withIndividual(9, 7)
                .withIndividual(10, 5).withIndividual(10, 6).withIndividual(10, 7)
                .withIndividual(11, 5).withIndividual(11, 7)
                .withIndividual(12, 5).withIndividual(12, 6).withIndividual(12, 7)
                .build();
    }

    private static World buildGlider() {
        return new WorldBuilder(10)
                .withIndividual(1,3)
                .withIndividual(2,1).withIndividual(2,3)
                .withIndividual(3,2).withIndividual(3,3)
                .build();
    }

    private static World buildBeacon() {
        return new WorldBuilder(6)
                .withIndividual(1,1).withIndividual(1,2)
                .withIndividual(2,1).withIndividual(2,2)
                .withIndividual(3,3).withIndividual(3,4)
                .withIndividual(4,3).withIndividual(4,4)
                .build();
    }

}