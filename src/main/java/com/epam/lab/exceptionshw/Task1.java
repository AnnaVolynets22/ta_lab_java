package com.epam.lab.exceptionshw;

import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static int squareRectangle(int a, int b){
        if (a < 0 || b <0){
            throw new InvalidParameterException("Negative value is entered");
        } else {
            return a * b;
        }
    }

    public static void main(String[] args){
        System.out.println("Please enter two integer parameters a and b:");
        Scanner scanner = new Scanner(System.in);
        try{
            int s = squareRectangle(scanner.nextInt(), scanner.nextInt());
            System.out.println("Rectangle square equals: " + s);

        }catch (InvalidParameterException e){
            System.out.println("Following exception was catched: " + e.getMessage());

        }catch(InputMismatchException e){
            System.out.println("Following exception was catched: " + e);
        }
    }
}
