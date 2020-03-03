import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Grid grid = makeInitialGrid();
        int count = 0;

        while (!grid.areAllSunk()) {
            System.out.println("========Battleship Grid========");
            System.out.println(grid);
            System.out.println("========Please enter a point of attack========");
            Coordinate coord = Util.parseCoordinate(input.next());
            if (grid.wouldAttackSucceed(coord)) {
                System.out.println("Direct Hit!");
                grid.attackCell(coord);
            }
            count++;
        }

        System.out.println("There were " + count + " attacks required to sink all ships!");
        System.out.println("========Final Grid========");
        System.out.println(grid);
    }

    private static Grid makeInitialGrid() {
        Grid grid = new Grid();

        String[] coords = { "A7", "B1", "B4", "D3", "F7", "H1", "H4" };
        int[] sizes = { 2, 4, 1, 3, 1, 2, 5 };
        boolean[] isDowns = { false, true, true, false, false, true, false };

        for (int i = 0; i < coords.length; i++) {
            Coordinate c = Util.parseCoordinate(coords[i]);
            grid.placeShip(c, sizes[i], isDowns[i]);
        }

        return grid;
    }
}
