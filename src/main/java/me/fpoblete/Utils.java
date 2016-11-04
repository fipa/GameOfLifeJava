package me.fpoblete;

class Utils {

    static int countFor(boolean[][] matrix, int x, int y) {

        int neighbours = 0;
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if (    (i == x && j == y) ||
                        (i < 0 || i >= matrix.length) ||
                        (j < 0 || j >= matrix[i].length) )
                {
                    continue;
                }

                neighbours += matrix[i][j] ? 1:0;
            }
        }

        return neighbours;
    }
}
