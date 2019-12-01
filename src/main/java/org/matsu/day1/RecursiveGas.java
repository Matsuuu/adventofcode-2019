package org.matsu.day1;

import org.matsu.util.FileUtil;

import java.util.List;

public class RecursiveGas {

    private int lowestMassThatRequiresFuel = 9;

    public static void main(String[] args) {
        new RecursiveGas();
    }

    private RecursiveGas() {
        List<String> moduleMasses = FileUtil.readFileToList("src/main/java/org/matsu/day1/modulemasses.txt");
        int totalFuelRequired = 0;

        for (String massString : moduleMasses) {
            int mass = Integer.parseInt(massString);
            System.out.println("Module mass: " + mass);
            totalFuelRequired += countTotalFuelRequiredForModule(mass, 0);
        }
        System.out.println("=================================");
        System.out.println("Total fuel: " + totalFuelRequired);
    }

    private int countTotalFuelRequiredForModule(int mass, int totalFuel) {
        int requiredFuel = ((int) Math.floor(mass / 3)) - 2;
        totalFuel += requiredFuel;
        if (requiredFuel >= lowestMassThatRequiresFuel) {
            System.out.println("Fuel needs fuel: " + requiredFuel);
            requiredFuel += countTotalFuelRequiredForModule(requiredFuel, totalFuel);
        }
        return requiredFuel;
    }
}
