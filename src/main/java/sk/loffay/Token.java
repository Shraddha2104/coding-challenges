package sk.loffay;

/**
 * @author Pavol Loffay
 */
public class Token {

    private Integer number;
    private Type type;


    private Token(Type type) {
        this(type, null);
    }

    private Token(Type type, Integer number) {
        this.type = type;
        this.number = number;
    }

    public static Token plus() {
        return new Token(Type.Plus);
    }

    public static Token minus() {
        return new Token(Type.Minus);
    }

    public static Token division() {
        return new Token(Type.Division);
    }

    public static Token multiplication() {
        return new Token(Type.Multiplication);
    }

    public static Token number(int number) {
        return new Token(Type.Number, number);
    }

    public boolean isOperator() {
        return type != Type.Number;
    }

    public Type getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public enum Type {
        Plus,
        Minus,
        Division,
        Multiplication,
        Number,
    }
}
