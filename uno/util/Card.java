package uno.util;

import java.util.Objects;

public class Card {
    public final Color color;
    public final CardType type;
    public final int value;

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Card card = (Card) other;
        return  Objects.equals(color, card.color) &&
                Objects.equals(type, card.type) &&
                value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, value);
    }

    public Card(Color color, CardType type, int value) {
        this.value = (type == CardType.VALUE) ? value : 0;
        this.color = color;
        this.type = type;
    }

    public boolean isPlayableOver(Card card) {
        if (this.type == CardType.VALUE) {
            return this.color == card.color || this.value == card.value;
        } else {
            return card.type == CardType.VALUE && this.color == card.color;
        }
    }

    @Override
    public String toString() {
        return color + " " + (type == CardType.VALUE ? Integer.valueOf(value).toString() : type);
    }
}