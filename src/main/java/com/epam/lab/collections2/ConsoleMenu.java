package com.epam.lab.collections2;

import java.awt.print.Printable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleMenu {
    private Map<MenuOptions, Printable> menu ;
    private static Scanner input = new Scanner(System.in);


    public void MyView(){
        menu = new LinkedHashMap<>();
       // menu.put(MenuOptions.OPTION1, this::testCommand);

    }

    private void testCommand(){}
    private void method2(){}


}
