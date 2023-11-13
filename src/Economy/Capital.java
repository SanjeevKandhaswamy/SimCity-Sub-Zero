package Economy;

public class Capital {
    private int capital;

    public Capital(){
        this.capital = 0;
    }

    public void setCapital(int value){
        capital += value;
    }

    public int getCapital(){
        return capital;
    }

    public boolean checkSufficientCapital(int amount) {
        return amount <= getCapital();
    }

}
