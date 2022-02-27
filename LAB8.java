import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LAB8 {
    private int nu;
    private int de;

    public LAB8(int num, int den) {
        this.nu = num;
        this.de = den;
        System.out.println(nu + "/" + de);
    }

    public static void defaultfraction() {
        System.out.println(1 + "/" + 1);
    }

    public static void multiply(LAB8 Fr1, LAB8 Fr2) {
        int numL = Fr1.nu * Fr2.nu;
        int denL = Fr1.de * Fr2.de;
        System.out.println("Операция умножения: " + numL + "/" + denL);
    }

    public static void divide(LAB8 Fr1, LAB8 Fr2) {
        int numL = Fr1.nu * Fr2.de;
        int denL = Fr1.de * Fr2.nu;
        System.out.println("Операция деления: " + numL + "/" + denL);
    }

    public static void plus(LAB8 Fr1, LAB8 Fr2) {
        int numL = Fr1.nu * Fr2.de + Fr1.de * Fr2.nu;
        int denL = Fr1.de * Fr2.de;
        System.out.println("Операция сложения: " + numL + "/" + denL);
    }


    public static void minus(LAB8 Fr1, LAB8 Fr2) {
        int numL = Fr1.nu * Fr2.de - Fr1.de * Fr2.nu;
        int denL = Fr1.de * Fr2.de;
        System.out.println("Операция вычитания: " + numL + "/" + denL);
    }

    public static void main(String args[]) {
        String aroper = null;
        int nu1 = 1;
        int nu2 = 1;
        int de1 = 1;
        int de2 = 1;
        String pattern = "^(-?\\d{1,10})/(-?\\d{1,10})( )[-+*:]( )(-?\\d{1,10})/(-?\\d{1,10})$";
        defaultfraction();
        Pattern p = Pattern.compile(pattern);
        Scanner data = new Scanner(System.in);
        System.out.println("Пожалуйста,введите выражение,которое будет состоять из двух простых дробей");
        String arithmetic = data.nextLine();
        data.close();
        Matcher m = p.matcher(arithmetic);
        if (m.matches() == true) {
            String[] piece = arithmetic.split("[/( )]+");
            nu1 = Integer.parseInt(piece[0]);
            de1 = Integer.parseInt(piece[1]);
            nu2 = Integer.parseInt(piece[3]);
            de2 = Integer.parseInt(piece[4]);
            aroper = piece[2];
            System.out.println("Данное выражение введено верно.");
        } else {
            System.out.println("Пожалуйста,введите выражение ещё раз (перезапустите перед этим программу).");
            System.exit(1);
        }
        System.out.println("Введеные дроби:");
        LAB8 Fr1 = new LAB8(nu1, de1);
        LAB8 Fr2 = new LAB8(nu2, de2);
        System.out.println(" ");
        if (aroper.equals("+")) {
            plus(Fr1, Fr2);
        }
        if (aroper.equals("-")) {
            minus(Fr1, Fr2);
        }
        if (aroper.equals("*")) {
            multiply(Fr1, Fr2);
        }
        if (aroper.equals(":")) {
            divide(Fr1, Fr2);

        }
    }
}
