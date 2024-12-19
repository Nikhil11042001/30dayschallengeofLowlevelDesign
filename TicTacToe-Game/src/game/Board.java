package game;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    public PlayerChoice [][] board;

    public Board(int size){
        this.size = size;
        board = new PlayerChoice[size][size];
    }

    public boolean addPiece(int x,int y,PlayerChoice playingPiece){
        if(board[x][y]==null){
            board[x][y]=playingPiece;
            return true;
        }
        return false;
    }
    public List<Pair> getFreeCells(){
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j =0;j<size;j++){
                if(board[i][j]==null){
                     Pair p1= new Pair(i,j);
                     list.add(p1);
                }
            }
        }
        return list;
    }

}
