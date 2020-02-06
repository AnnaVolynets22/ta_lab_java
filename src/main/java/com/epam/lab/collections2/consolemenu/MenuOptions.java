package com.epam.lab.collections2.consolemenu;

public enum MenuOptions {
    OPTION1(1, "Execute method 1"),
    OPTION2(2, "Execute method 2"),
    OPTION3(3, "Execute method 3"),
    OPTION4(4, "Exit")
    ;

    private Integer menuOption;
    private String optionDescription;

    private MenuOptions(Integer menuOption, String optionDescription)
    {
        this.menuOption = menuOption;
        this.optionDescription = optionDescription;
    }

    public Integer getMenuOption() {
        return menuOption;
    }

    public String getOptionDescription(){
        return optionDescription;
    }
}
