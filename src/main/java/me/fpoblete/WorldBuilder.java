package me.fpoblete;

public class WorldBuilder {

    private World world;

    public WorldBuilder() {

    }

    public WorldBuilder(int size) {
        this.world = new World(size);
    }

    public WorldBuilder(int rows, int columns) {
        this.world = new World(rows, columns);
    }

    public WorldBuilder withIndividual(int x, int y) {
        this.world.setAlive(x, y);
        return this;
    }

    public WorldBuilder withRandonInvidivuals(int size) {
        this.world = new World(size, true);
        return this;
    }

    public World build() {
        return this.world;
    }
}
