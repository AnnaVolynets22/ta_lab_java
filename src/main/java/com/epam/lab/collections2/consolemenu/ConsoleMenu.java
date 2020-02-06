package com.epam.lab.collections2.consolemenu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleMenu {
    private static Logger logger1 = LogManager.getLogger(ConsoleMenu.class);
    private Map<Integer, Showable> menu ;
    private static Scanner input = new Scanner(System.in);


    public void myView(){
        menu = new LinkedHashMap<>();
        menu.put(MenuOptions.OPTION1.getMenuOption(), this::method1);
        menu.put(MenuOptions.OPTION2.getMenuOption(), this::method2);
        menu.put(MenuOptions.OPTION3.getMenuOption(), this::method3);
    }

    private void method1(){logger1.info("Method 1 is executed.");}
    private void method2(){logger1.info("Method 2 is executed.");}
    private void method3(){logger1.info("Method 3 is executed.");}

    private void outputMenu(){
        logger1.info("Menu:");
        for(MenuOptions option: MenuOptions.values())
        logger1.info( option.getMenuOption().toString() +
                " " + option.getOptionDescription());
    }

    public void demo(){
        int keyMenu = 0;
        do{
            outputMenu();
            logger1.info("Please, select menu point.");
            keyMenu = input.nextInt();
            try{
                menu.get(keyMenu).show();
            } catch(Exception e){
            }
        }while(keyMenu != 4);


    }
}
