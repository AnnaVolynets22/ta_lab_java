package com.epam.lab.lambdastreams.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
    Executor command1 = (s)->logger.info("Executing lambda " + s);
    Executor command2 = logger::info;
    Executor command3 = new Executor() {
        @Override
        public void execute(String s) {
            logger.info("Executing anonymous class method with parameter:" + s);
        }
    };
    Executor command4 = new Command();

        Map<String, Executor> menu = new HashMap<>();
        menu.put("lambda", command1);
        menu.put("reference", command2);
        menu.put("anonymous", command3);
        menu.put("class", command4);
        logger.info("Following commands are available: lambda, reference, anonymous, class");
        String command = new Scanner(System.in).nextLine();
        logger.info("Please enter command parameter:");
        String param = new Scanner(System.in).nextLine();

        Executor commandSelected = menu.get(command);
        commandSelected.execute(param);
    }
}
