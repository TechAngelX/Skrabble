package pij.main;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class game_Start {
    private String boardType;

    public void intro_Header() {
        System.out.println("============                   ============");
        System.out.println("============ S k r a B B K l e ============");
        System.out.println("============                   ============");
    }

    public void board_Config() {
        System.out.print("Would you like to _l_oad a board or use the _d_ef board?\n");
        System.out.print("Please enter your choice (l/d): ");
        try (Scanner scanner = new Scanner(System.in)) {

            String boardType;
            while (true) {

                //formats the string to lowercase and first character:
                boardType = scanner.nextLine().toLowerCase().substring(0, 1);
                if (boardType.equals("l") || (boardType.equals("d"))) {
                    if (boardType.equals("l")) {
                        loadBoard();
                    } else {
                        defBoard();
                    }
                    break;
                } else {
                    System.out.print("Invalid Entry. Please enter your choice (only 'l' or 'd'): ");
                }
            }
            System.out.println("your option is: " + boardType);

        } catch (Exception e) {
            System.out.println("Invalid entry.");
        }
    }

    public void loadBoard(){
        System.out.println("loadboard");
    }

    public void defBoard(){
        System.out.println("defBoard");
    }
}


