package main;

import Files.FileWriter1;
import JSONSortie.UnJSON;

public class Main {

    public static String tmp[] = new String[3];

    public static void main(String[] args) throws Exception {
        tmp = args;
        FileWriter1.ecrire(args[1]);
    }
}
