package Karty;

import java.util.Objects;

public class Card {
    private final int VALUE;


    public int getVALUE() {
        return VALUE;
    }

    public String getSUIT() {
        return SUIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return VALUE == card.VALUE && Objects.equals(SUIT, card.SUIT);
    }

    @Override
    public String toString() {
        return SUIT + "" + VALUE;
    }

    private final String SUIT;
// Конструктор для инициализации карты с указанием
    public Card(int value, String SUIT) {
        this.VALUE = value;
        this.SUIT = SUIT;
    }

    @Override
    public int hashCode() {
        return Objects.hash(VALUE, SUIT);
    }

}
