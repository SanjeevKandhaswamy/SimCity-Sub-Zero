import java.util.ArrayList;
import java.util.List;

import Buildings.Building;


public class City {
    private int city_id;
    private String city_name;
    private int population, income, capital; //capital is the present money in hand

    private List<Building> buildings;

    private Building[][] map;

    //constructor
    public City(int city_id, String city_name, int income) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.buildings = new ArrayList<>();
        this.map = new Building[50][50];
    }

    public void manageEconomy(){

    }
    
    public void ViewStats() {
    	
    }
}
