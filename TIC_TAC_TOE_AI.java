import java.util.Scanner;

public class TicTacToeAI {
    public static void main(String[] args) {
        // Initialize the game board
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char currentPlayer = 'X';

         // Display the initial game board
         displayBoard(board);

         // Game loop
        while (true) {
            if (currentPlayer == 'X') {
    
        // Player X makes a move
        makeMove(board, currentPlayer);
    } else {
        // AI's turn (O)
        int[] bestMove = findBestMove(board);
        board[bestMove[0]][bestMove[1]] = currentPlayer;
    }
    // Display the updated game board
    displayBoard(board);

     // Check for a winner or a draw
     if (isWinner(board, currentPlayer)) {
        System.out.println((currentPlayer == 'X' ? "Player X" : "AI O") + " wins!");
        break;
    } else if (isBoardFull(board)) {
        System.out.println("It's a draw!");
        break;
    }
     // Switch players
     currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
// Function to display the game board
private static void displayBoard(char[][] board) {
    System.out.println("-------------");
    for (int i = 0; i < 3; i++) {
        System.out.print("| ");
        for (int j = 0; j < 3; j++) {
            System.out.print(board[i][j] + " | ");
        }
        System.out.println("\n-------------");
    }
}
// Function for the player to make a move
private static void makeMove(char[][] board, char player) {
    Scanner scanner = new Scanner(System.in);
    int row, col;

    // Get valid move from the player
    do {
        System.out.println("Player " + player + ", enter your move (row and column): ");
        row = scanner.nextInt();
        col = scanner.nextInt();
    } while (!isValidMove(board, row, col));

    // Update the board with the player's move
    board[row][col] = player;
}
 // Function to check if a move is valid
 private static boolean isValidMove(char[][] board, int row, int col) {
    return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
}
// Function to check if there is a winner
private static boolean isWinner(char[][] board, char player) {
    // Check rows, columns, and diagonals for a winning combination
    for (int i = 0; i < 3; i++) {
        if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
            (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
            return true;
        }
    }
    return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
    (board[0][2] == player && board[1][1] == player && board[2][0] == player);
}
// Function to check if the board is full (a draw)
private static boolean isBoardFull(char[][] board) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == ' ') {
                return false;
            }
        }
    }
    return true;
}
// Function to find the best move using the minimax algorithm
private static int[] findBestMove(char[][] board) {
    int bestVal = Integer.MIN_VALUE;
    int[] bestMove = {-1, -1};
 // Traverse all cells, evaluate minimax function for all empty cells, and return the cell with optimal value
 for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (board[i][j] == ' ') {
            board[i][j] = 'O';
            int moveVal = minimax(board, 0, false);
            board[i][j] = ' '; // Undo the move
            if (moveVal > bestVal) {
                bestMove[0] = i;
                bestMove[1] = j;
                bestVal = moveVal;
            }
        }
    }
}
return bestMove;
}
}
    