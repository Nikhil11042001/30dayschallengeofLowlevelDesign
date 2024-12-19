package game;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    Deque<Player> players;
    Board gameBoard;

    public TicTacToe(){
        initialization();
    }

    public void initialization() {
        players=new LinkedList<>();
        PlayerChoiceX player1Choice = new PlayerChoiceX();
        PlayerChoiceO player2Choice = new PlayerChoiceO();
        Player player1 =  new Player("Nikhil",player1Choice);
        Player player2 =  new Player("Purvi",player2Choice);
        players.add(player1);
        players.add(player2);
        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            Player p1 = players.removeFirst();
            List<Pair> list  = gameBoard.getFreeCells();
            if(list.isEmpty()){ noWinner =false;continue;}
            System.out.println(p1.getName()+" Please choose the cells :");
            Scanner input = new Scanner(System.in);
            String s1 = input.nextLine();
            String [] stringArray = s1.split(",");
            int inputRow = Integer.valueOf(stringArray[0]);
            int inputColumn = Integer.valueOf(stringArray[1]);
            boolean isAddedSuccesfully = gameBoard.addPiece(inputRow,inputColumn,p1.playerChoice);
            if(!isAddedSuccesfully){
                System.out.println("Incorrect position Choosen");
                players.addLast(p1);continue;
            }
            players.addLast(p1);
             boolean isWinner  = isThereWinner(inputRow,inputColumn,p1.playerChoice.playerChoiceEnum);
             if(isWinner) return p1.getName();

        }
        return "tie";
    }

    private boolean isThereWinner(int inputRow, int inputColumn, PlayerChoiceEnum playerChoiceEnum) {
        boolean rowMatch=true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;
        for(int i =0;i<gameBoard.size;i++){
            if(gameBoard.board[inputRow][i]==null||gameBoard.board[inputRow][i].playerChoiceEnum!=playerChoiceEnum){
                rowMatch=false;
            }
        }
        for(int i =0;i<gameBoard.size;i++){
            if(gameBoard.board[i][inputColumn]==null||gameBoard.board[i][inputColumn].playerChoiceEnum!=playerChoiceEnum){
                columnMatch=false;
            }
        }

        for(int i=0,j=0;i<gameBoard.size;i++,j++){
            if(gameBoard.board[i][j]==null||gameBoard.board[i][j].playerChoiceEnum!=playerChoiceEnum){
                diagonalMatch=false;
            }
        }
        for(int i=0,j= gameBoard.size-1;i<gameBoard.size;i++,j--){
            if(gameBoard.board[i][j]==null||gameBoard.board[i][j].playerChoiceEnum!=playerChoiceEnum){
                antiDiagonalMatch=false;
            }
        }

        return rowMatch||columnMatch||diagonalMatch||antiDiagonalMatch;
    }


}
