package org.matsu.day1;

import org.matsu.util.FileUtil;

import java.util.List;

public class Gas {
    public static void main(String[] args) {
        new Gas();
    }

    private Gas() {
        String filePath = "src/main/java/org/matsu/day1/modulemasses.txt";
        List<String> moduleMasses = FileUtil.readFileToList(filePath);
        int totalFuelRequired = 0;

        for (String massString : moduleMasses) {
            int mass = Integer.parseInt(massString);
            int fueldRequired = calculateRequiredFuel(mass);
            System.out.println("Mass is: " + mass);
            System.out.println("Fuel needed is: " + fueldRequired);

            totalFuelRequired += fueldRequired;
        }
        System.out.println("===========================================");
        System.out.println("Total fuel required is: " + totalFuelRequired);
    }

    private int calculateRequiredFuel(int mass) {
        return ((int) Math.floor(mass / 3)) - 2;
    }
}
