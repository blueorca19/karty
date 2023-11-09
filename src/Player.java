import Karty.Card;

import java.util.Arrays;
import java.util.Comparator;

public class Player implements GameInterface{

    private final String NAME;
    //карты в текущем раунде
    private Card[] hand;



    //суммарное значение карт
    private int score;
    //общий счет за всю игру (количество побед)
    private int totalScore;


    public Player(String NAME) {
        this.NAME = NAME;
        this.hand = new Card[0];
    }

    //добавление карты и обновления счета score
    public void drawCard(Card card) {
        Card[] copy = Arrays.copyOf(this.hand, this.hand.length + 1);
        copy[copy.length - 1] = card;
        this.hand = copy;
       // Comparator
        //arrays.sort
        this.score += card.getVALUE();
        Arrays.sort(this.hand, Comparator.comparing(Card::getSUIT).thenComparing(Card::getVALUE));

    }
    //ResetRound сброс руки и счета за раунд
    public void resetRound() {
        this.score = 0;
        this.hand = new Card[0];

    }

    //Метод для добавления балла к общему счету
    public void addPointToTotalScore() {
        this.totalScore++;

    }
    public int getScore() {
        return score;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
