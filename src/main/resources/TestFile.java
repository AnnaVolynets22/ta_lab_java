//comment at first line

public class TestFile {
    private String name;
    private final String CONST = "//asasdda/*hjkddcc//";

    public Droid(String name) {
        this.name = name;//comment after semicolon
    }

    public String getName() {
        //comment inside method
        return name;
    }
/*
Some multiple
comment
 */
    @Override
    public String toString() {
        return "Droid{" +
                "name:" + getName() +
                '}//';
    }
}