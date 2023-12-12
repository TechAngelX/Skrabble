package pij.main;

import java.util.Scanner;

public class game_Start {
    private String boardType;

    public void intro_Header(){
        System.out.println("============                   ============");
        System.out.println("============ S k r a B B K l e ============");
        System.out.println("============                   ============");
    }

    public String board_Config() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to _l_oad a board or use the _d_ef board?\n" +
                "Please enter your choice (l/d): ");
        String boardType = scanner.nextLine().toLowerCase().substring(0, 1);
        System.out.println("your option is: " + boardType);
        return boardType;


    }
}
