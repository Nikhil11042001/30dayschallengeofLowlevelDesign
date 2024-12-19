package game;

public class Player {
    String name;

    PlayerChoice playerChoice;

    public Player(String name, PlayerChoice playerChoice) {
          this.name = name;
         this.playerChoice = playerChoice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerChoice getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(PlayerChoice playerChoice) {
        this.playerChoice = playerChoice;
    }
}
