public class Grid {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private final Piece[][] grid = new Piece[HEIGHT][WIDTH];

    public Grid() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                grid[i][j] = Piece.WATER;
            }
        }
    }

    public boolean canPlace(Coordinate c, int size, boolean isDown) {
        if (isDown) {
            int col = c.getColumn();
            for (int i = c.getRow(); i < size; i++) {
                if (grid[i][col] !=  Piece.WATER) {
                    return false;
                }
            }
        } else {
            int row = c.getRow();
            for (int i = c.getColumn(); i < size; i++) {
                if (grid[row][i] != Piece.WATER) {
                    return false;
                }
            }
        }

        return true;
    }

    public void placeShip(Coordinate c, int size, boolean isDown) {
        if (canPlace(c, size, isDown)) {
            if (isDown) {
                int col = c.getColumn();
                int row = c.getRow();
                for (int i = row; i < row + size; i++) {
                    grid[i][col] = Piece.SHIP;
                }
            } else {
                int row = c.getRow();
                int col = c.getColumn();
                for (int i = col; i < col + size; i++) {
                    grid[row][i] = Piece.SHIP;
                }
            }
        }
    }

    public boolean wouldAttackSucceed(Coordinate c) {
        if (grid[c.getRow()][c.getColumn()] == Piece.SHIP) {
            return true;
        }
        return false;
    }

    public void attackCell(Coordinate c) {
        if (wouldAttackSucceed(c)) {
            int row = c.getRow();
            int col = c.getColumn();
            if (grid[row][col] == Piece.SHIP) {
                grid[row][col] = Piece.DAMAGED_SHIP;
            } else if (grid[row][col] == Piece.WATER) {
                grid[row][col] = Piece.MISS;
            }
        }
    }

    public boolean areAllSunk() {
        for (Piece[] i : grid) {
            for (Piece j : i) {
                if (j == Piece.SHIP) {
                    return false;
                }
            }
        }

        return true;
    }

    public String toPlayerString() {
        Piece[][] newGrid = Util.deepClone(grid);
        Util.hideShips(newGrid);
        return renderGrid(newGrid);
    }

    @Override
    public String toString() {
        return renderGrid(grid);
    }

    private static String renderGrid(Piece[][] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 0123456789\n");
        for (int i = 0; i < grid.length; i++) {
            sb.append((char) ('A' + i));
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == null) {
                    return "!";
                }
                switch (grid[i][j]) {
                case SHIP:
                    sb.append('#');
                    break;
                case DAMAGED_SHIP:
                    sb.append('*');
                    break;
                case MISS:
                    sb.append('o');
                    break;
                case WATER:
                    sb.append('.');
                    break;
                }

            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
