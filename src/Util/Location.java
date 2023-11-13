package Util;

public class Location {
    private int x;
    private int y;

    // Constructor
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setLocation(int new_x, int new_y){
        this.x = new_x;
        this.y = new_y;
    }

    public int getX() {
        return x;
    }

    // Getter for y
    public int getY() {
        return y;
    }

    public Location getLocation(){
        return this;
    }
}
