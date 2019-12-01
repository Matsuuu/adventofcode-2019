package org.matsu.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static String readFile(String filePath) {
        File file = new File(filePath);
        StringBuilder buffer = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while((line = in.readLine()) != null) {
                buffer.append(line);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static List<String> readFileToList(String filePath) {
        File file = new File(filePath);
        List<String> list = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while((line = in.readLine()) != null) {
                list.add(line);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
