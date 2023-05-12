import java.util.*;

public class SudokuSolver {
    private int[][] board;

    public SudokuSolver(int[][] board) {
        this.board = board;
    }

    public boolean solve() {
        int[] emptyCell = findEmptyCell();
        if (emptyCell == null) {
            return true;
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        Set<Integer> possibleValues = getPossibleValues(row, col);

        for (int value : possibleValues) {
            board[row][col] = value;

            if (solve()) {
                return true;
            }

            board[row][col] = 0;
        }

        return false;
    }

    private int[] findEmptyCell() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }

        return null;
    }

    private Set<Integer> getPossibleValues(int row, int col) {
        Set<Integer> possibleValues = new HashSet<>();
        for (int value = 1; value <= 9; value++) {
            possibleValues.add(value);
        }

        // Check row
        for (int c = 0; c < 9; c++) {
            possibleValues.remove(board[row][c]);
        }

        // Check column
        for (int r = 0; r < 9; r++) {
            possibleValues.remove(board[r][col]);
        }

        // Check box
        int boxRow = row / 3 * 3;
        int boxCol = col / 3 * 3;
        for (int r = boxRow; r < boxRow + 3; r++) {
            for (int c = boxCol; c < boxCol + 3; c++) {
                possibleValues.remove(board[r][c]);
            }
        }

        return possibleValues;
    }

    public void printBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] puzzle = {
                {0, 0, 0, 5, 0, 8, 0, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 0, 0, 0, 2, 0},
                {9, 0, 0, 0, 0, 0, 0, 0, 5},
                {0, 5, 0, 0, 0, 0, 0, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 0, 3, 0, 0}
        };

        SudokuSolver solver = new SudokuSolver(puzzle);
        if (solver.solve()) {
            System.out.println("Solved puzzle:");
            solver.printBoard();
        } else {
            System.out.println("Puzzle could not be solved.");
        }
    }

}
