package uno;

import uno.util.*;

import java.util.LinkedList;
import java.util.List;

public class Game {
    LinkedList<Card> deck;
    List<Player> players;
    Card currentCard;
    int currentPlayerIdx;
    boolean isForward;
    boolean isOn;
    InputSource inputSource;

    public Game(int cardsCount, InputSource input, String... names) throws NotEnoughPlayersException {
        if (names.length < 2) {
            throw new NotEnoughPlayersException(names.length);
        }

        initDeck();
        initPlayers(cardsCount, names);
        currentPlayerIdx = drawCards();
    }

    private void initPlayers(int cardsPerPlayer, String... names) {
        players = new LinkedList<>();
        for(int i=0; i<names.length; i++) {
            players[i] = new Player(names[i], drawCards(cardsPerPlayer), this);
        }
    }

    private List<Card> drawCards(int n) {
        LinkedList<Card> cards = new LinkedList<>();
        while (n-- > 0) {
            cards.add(deck.removeFirst());
        }
        return cards;
    }
    
    public static void main(String[] args) throws NotEnoughPlayersException {
        Game game = new Game(6, new InputSource(true), args);
    } 

    public void playNext() {

    }

    public int getNextPlayerIdx() {
        return 0;
    }

    private void currentPlayerDrawCard() {

    }

    public Player getCurrentPlayer() {
        return null;
    }

    private void useCardEffect() {

    }

    private void initDeck() {
        for (Color c : Color.values()) {
            for (int i = 1; i <= 9; i++) {
                deck.add(new Card(c, CardType.VALUE, i));
            }

            for (CardType t : CardType.values()) {
                deck.add(new Card(c, t, 0));
            }
        }

        if (inputSource.isInteractive)
            Collections.shuffle(deck);
        else
            Collections.shuffle(deck, new java.util.Random(12345));
    }

    private void interactiveMsg(String msg) {
        
    }

    // getters, setters
    public List<Player> getPlayers() {
        return players;
    }
}