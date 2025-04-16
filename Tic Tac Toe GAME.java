import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        boolean gameEnded = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameEnded) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            String input = scanner.nextLine();

            if (!isValidMove(input)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            makeMove(input.charAt(0));
            if (checkWin()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                switchPlayer();
            }
        }

        scanner.close();
    }

    static void printBoard() {
        System.out.println();
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(" " + cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isValidMove(String input) {
        if (input.length() != 1 || input.charAt(0) < '1' || input.charAt(0) > '9')
            return false;

        char move = input.charAt(0);
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == move) {
                    return true;
                }
            }
        }
        return false;
    }

    static void makeMove(char move) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == move) {
                    board[i][j] = currentPlayer;
                    return;
                }
            }
        }
    }

    static boolean checkWin() {
        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer &&
                 board[i][1] == currentPlayer &&
                 board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer &&
                 board[1][i] == currentPlayer &&
                 board[2][i] == currentPlayer)) {
                return true;
            }
        }

        // Diagonals
        if ((board[0][0] == currentPlayer &&
             board[1][1] == currentPlayer &&
             board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer &&
             board[1][1] == currentPlayer &&
             board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    static boolean isDraw() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell >= '1' && cell <= '9') {
                    return false;
                }
            }
        }
        return true;
    }

    static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
