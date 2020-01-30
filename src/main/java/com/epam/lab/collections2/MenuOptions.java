package com.epam.lab.collections2;

public enum MenuOptions {
    OPTION1(1),
    OPTION2(2),
    OPTION3(3)
    ;

    private int menuOption;

    private MenuOptions(int menuOption) {
        this.menuOption = menuOption;
    }
}
