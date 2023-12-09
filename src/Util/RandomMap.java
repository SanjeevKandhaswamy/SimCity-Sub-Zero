package Util;

import java.util.Random;
import Buildings.Building;
import Buildings.ResidentialBuilding;
import Buildings.CommercialBuilding;
import Buildings.IndustrialBuilding;

public class RandomMap {

    private static int uniqueIdCounter = 1;

    public static Building[][] generateRandomMap(int size) {
        Building[][] randomMap = new Building[size][size];
        Random random = new Random();

        for (int i = 0; i < randomMap.length; i++) {
            for (int j = 0; j < randomMap[i].length; j++) {
                Building randomBuilding = getRandomBuilding(random, size);
                randomMap[i][j] = randomBuilding;
            }
        }

        return randomMap;
    }

    private static Building getRandomBuilding(Random random, int size) {
        Building[] possibleBuildings = {
                new ResidentialBuilding(generateUniqueId(), generateRandomLocation(size, random), 1, null),
                new CommercialBuilding(generateUniqueId(), generateRandomLocation(size, random), 1, null),
                new IndustrialBuilding(generateUniqueId(), generateRandomLocation(size, random), 1, null)
        };
        int randomIndex = random.nextInt(possibleBuildings.length);
        return possibleBuildings[randomIndex];
    }

    private static String generateUniqueId() {
        return "ID" + uniqueIdCounter++;
    }

    private static Location generateRandomLocation(int size, Random random) {
        int x = random.nextInt(size);
        int y = random.nextInt(size);
        return new Location(x, y);
    }
}
