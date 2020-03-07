package com.epam.lab.patterns.state_kanban_board;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String keyMenu;
        Ticket ticket= new Ticket();
        do {
            log.info("   1 - Add new ticket");
            log.info("   2 - Move to in progress State ");
            log.info("   3 - Move to  code review State " );
            log.info("   3 - Close ticket." );
            log.info("   S - Get current state" );
            log.info("   Q - exit");
            log.info("   Please, select menu point.");

            keyMenu = input.nextLine().toUpperCase();
            try {
                switch (keyMenu) {
                    case "1":
                        ticket.addToDoState();
                        break;
                    case "2":
                        ticket.inProgressState();
                        break;
                    case "3":
                        ticket.codeReviewState();
                        break;
                    case "4":
                        ticket.doneState();
                        break;
                     case "S":
                        ticket.showCurrentState();
                        break;
                }
            } catch (Exception e) {
                log.info(e.getMessage());
            }
        } while (!keyMenu.equals("Q"));
    }
}
