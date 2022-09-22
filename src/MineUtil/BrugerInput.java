package MineUtil;

import java.util.Scanner;

public class BrugerInput
{
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
