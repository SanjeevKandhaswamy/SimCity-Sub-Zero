public class GameData {
    private String saveName;

    //Constructor
    public GameData(String name) {
        this.saveName = name;
    }

    public void setSaveName(String new_name){
        this.saveName = new_name;
    }

    public String getSaveName(){
        return saveName;
    }

    public void loadGame() {
        System.out.println("Loading game from " + saveName);
    }

    public void saveGame() {
        System.out.println("Saving game to " + saveName);
    }

    public void endGame() {
        System.out.println("Ending the game");
    }
}
