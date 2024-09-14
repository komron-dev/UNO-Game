package uno;

import uno.util.*;

import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private Game game;

    public Player(String name, List<Card> hand, Game game) {
        this.name = name;
        this.hand = hand;
        this.game = game;
    } 

    public void addToHand(List<Card> cards) {

    }

    public void removeFromHand(int n) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + ":");

        for(int i=0; i < hand.size(); i++) {
            Card c = hand.get(i);
            sb.append(String.format(" <%d>=", i+1));
            if(c.isPlayableOver(game.currentCard)) {
                sb.append("*");
            }
            sb.append(c.toString());
        }
        return sb.toString();
    }

    // getters, setters
    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }
}