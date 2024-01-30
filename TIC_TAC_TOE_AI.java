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

}
    }
