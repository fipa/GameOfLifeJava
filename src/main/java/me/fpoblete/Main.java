package me.fpoblete;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Main {

    public static void main(String [] args) throws InterruptedException {

        clearScreen();
        System.out.println("Game of life");

        if (args == null || args.length == 0) {
            displayHelp();
        } else {

            String firstArg = args[0];
            String secondArg = args[1];

            if (firstArg == null || secondArg == null) {
                displayHelp();
            } else if ("-n".equals(firstArg) && Integer.parseInt(secondArg) >= 4 && Integer.parseInt(secondArg) <= 30) {
                run(WorldFactory.getRandomWorld(Integer.parseInt(secondArg)));
            } else if ("-t".equals(firstArg)) {
                try {
                    run(WorldFactory.getPreDefinedWorld(secondArg));
                } catch (NotImplementedException e) {
                    displayHelp();
                }
            } else {
                displayHelp();
            }
        }
    }

    private static void displayHelp() {
        System.out.println("Usage:");
        System.out.println("Random world, size n: -n <size> (4<= n <=30)");
        System.out.println("Predefined types: -t <type> (at the moment, just Pentadecathlon, Glider, Beacon)");
    }

    private static void run(World world) throws InterruptedException {
        Thread.sleep(2000L);

        clearScreen();
        for (int i = 0; i < 100; i++) {
            world.nextGeneration();
            System.out.println("Generation " + i + ": population size = " + world.countIndividuals());
            System.out.print(world.toString());
            Thread.sleep(750L);
            clearScreen();
        }
    }

    private static void clearScreen() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
