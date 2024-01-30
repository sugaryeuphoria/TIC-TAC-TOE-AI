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
    }}
        // Player X makes a move
        makeMove(board, currentPlayer);
    } else {
        // AI's turn (O)
        int[] bestMove = findBestMove(board);
        board[bestMove[0]][bestMove[1]] = currentPlayer;
    }
    // Display the updated game board
    displayBoard(board);
