package MineUtil;

import Entitet.Bog;
import Entitet.Låner;

import java.util.List;
import java.util.Scanner;

public class UI
{
    public static void udskrivBog (List<Bog> bogList) {

        for (Bog bog : bogList) {

            System.out.println(bog.toString());
        }

    }

    public static void udskrivLåner (List<Låner> lånerList){

        for (Låner låner : lånerList) {
            System.out.println(låner.toString());
        }
    }
    public static String getString(String s) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(s + " : ");
        return scanner.nextLine();

    }
    public static int getInt(String s) {
        while (true) {
            try {
                return Integer.parseInt(getString(s));
            }catch (NumberFormatException e) {
                System.out.println("forkert");
            }
        }
    }
}
