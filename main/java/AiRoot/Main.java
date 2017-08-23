package AiRoot;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String dir = "C:\\Users\\subar\\Desktop\\ai_root\\src\\main\\root\\default.root";

        Read r = new Read();
        r.getContents(dir);

        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println(r.getResponse(s.nextLine()));
        }
    }
}