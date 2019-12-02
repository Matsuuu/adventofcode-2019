package org.matsu.day2;

import org.matsu.util.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Intcode {

    private int currentOpCodePosition = 0;
    private ArrayList<Integer> intCodes;
    private boolean running;
    private int programOutput = 0;

    private Intcode() {
        new Intcode(12, 2);
    }

    private Intcode(int noun, int verb) {
        intCodes = Arrays.stream(FileUtil.readFile("src/main/java/org/matsu/day2/intcodes.txt")
                .split(","))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        running = true;

        intCodes.set(1, noun);
        intCodes.set(2, verb);
        while(currentOpCodePosition < intCodes.size() && running) {
            processOpCode();
        }
        System.out.println("At position 0 is " + intCodes.get(0));
        programOutput = intCodes.get(0);
    }

    private void processOpCode() {
        int opCode = intCodes.get(currentOpCodePosition);
        int param1 = intCodes.get(intCodes.get(currentOpCodePosition + 1));
        int param2 = intCodes.get(intCodes.get(currentOpCodePosition + 2));
        int destination = intCodes.get(currentOpCodePosition +3);
        System.out.println(intCodes);

        System.out.println(opCode);
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(destination);
        switch (opCode) {
            case 1:
                intCodes.set(destination, param1 + param2);
                break;
            case 2:
                intCodes.set(destination, param1 * param2);
                break;
            case 99:
                running = false;
                break;
            default:

                break;
        }
        currentOpCodePosition += 4;
        System.out.println(intCodes);
        System.out.println("=====================================");
    }

    public int getProgramOutput() {
        return programOutput;
    }

    public static void main(String[] args) {
        new Intcode();
        for (int i = 0; i <= 100; i++) {
            for (int j = 0;j <= 100; j++) {
                Intcode program = new Intcode(i, j);
                if (program.getProgramOutput() == 19690720) {
                    System.out.println("Found it!");
                    System.out.println(100 * i + j);
                    throw new RuntimeException("Finished");
                }
            }
        }
    }
}
