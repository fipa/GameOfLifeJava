package me.fpoblete;

public class World {

    private boolean[][] matrix;

    public World(int size) {
        this.matrix = new boolean[size][size];
    }

    public World(int size, boolean generateRandom) {
        this.matrix = new boolean[size][size];

        if (generateRandom) {
            generateRandomMatrix(size, size);
        }
    }

    public World(int rows, int columns) {
        this.matrix = new boolean[rows][columns];
    }

    public World(int rows, int columns, boolean generateRandom) {
        this.matrix = new boolean[rows][columns];

        if (generateRandom) {
            generateRandomMatrix(rows, columns);
        }
    }

    public void nextGeneration() {
        boolean newMatrix[][] = new boolean[this.countRows()][this.countColumns()];

        for (int i = 0; i < this.countRows(); i++) {
            for (int j = 0; j < this.countColumns(); j++) {
                newMatrix[i][j] = this.willBeAlive(i, j);
            }
        }

        this.matrix = newMatrix;
    }

    @Override
    public String toString() {
        String worldString = "";

        for (int i = 0; i < this.countRows(); i++) {
            for (int j = 0; j < this.countColumns(); j++) {
                worldString+= this.isAlive(i,j) ? "O":".";
            }
            worldString+= "\n";
        }

        return worldString;
    }

    public int countIndividuals() {
        int individuals = 0;

        for (int i = 0; i < this.countRows(); i++) {
            for (int j = 0; j < this.countColumns(); j++) {
                individuals += isAlive(i,j) ? 1 : 0;
            }
        }

        return individuals;
    }


    void setMatrix(boolean[][] matrix) {
        this.matrix = matrix;
    }

    void setAlive(int x, int y) {
        this.matrix[x][y] = true;
    }

    int countRows() {
        return this.matrix.length;
    }

    int countColumns() {
        return this.matrix[0].length;
    }

    boolean willBeAlive(int x, int y) {
        int neighbours = Utils.countFor(this.matrix, x, y);
        boolean isAlive = isAlive(x, y);

        return (isAlive && staysAlive(neighbours) ||
                !isAlive && isBorn(neighbours));
    }

    private void generateRandomMatrix(int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] = Math.round(Math.random()) % 2 == 0;
            }
        }
    }

    private boolean isAlive(int x, int y) {
        return this.matrix[x][y];
    }

    private boolean staysAlive(int neighbours) {
        return neighbours == 2 || neighbours == 3;
    }

    private boolean isBorn(int neighbours) {
        return neighbours == 3;
    }

}