package uno.util;

public class NotEnoughPlayersException extends Exception {
    public NotEnoughPlayersException(int n) {
        super("Only " + n + " players were given");
    }
}