import game.TicTacToe;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TicTacToe x= new TicTacToe();
        String s1 = x.startGame();
        System.out.println(s1);
    }
}