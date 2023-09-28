import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner (System.in);
        System.out.println("Введите выражение");
        String inputSum = scanner.nextLine();
        if (inputSum.length() < 5) throw new Exception("Строка не является математической операцией");

    System.out.println(calc(inputSum));
    }
    public static String calc(String input) throws Exception {

        String[] words = input.split(" ");
        if (words.length > 3) throw new Exception("Больше двух операндов");
        String a = words[0];
        String b = words[2];
        char c = words[1].charAt(0);
        Perevod perevod = new Perevod();
        return perevod.sum(a, b, c);
    }
}
