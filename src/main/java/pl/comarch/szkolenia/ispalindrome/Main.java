package pl.comarch.szkolenia.ispalindrome;

import pl.comarch.szkolenia.ispalindrome.database.DataBase;
import pl.comarch.szkolenia.ispalindrome.gui.GUI;

import pl.comarch.szkolenia.ispalindrome.database.DataBase;
import pl.comarch.szkolenia.ispalindrome.gui.GUI;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> inputFile = DataBase.getInstance().getStrings();
        GUI.displayDataBase(inputFile);
        ArrayList<String> result = new ArrayList<>();

        for (String str : inputFile) {
            if(checkIsPalindrome(str)) result.add(str);
        }
        System.out.println("---------");
        GUI.displayDataBase(result);
        saveFile(result);

    }

    public static boolean checkIsPalindrome(String str) {
        String r = reverse(str);
        return str.equals(r) ? true : false;
    }

    public static String reverse(String str) {
        String result = "";
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            result = ch + result;
        }
        return result;
    }
    public static void saveFile (ArrayList<String> strings) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("results.txt"))) {
            for (String str : strings) {
                bw.write(str);
                bw.newLine();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
