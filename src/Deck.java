import Karty.Card;

import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Deck implements Iterable<Card> {
    //это наша колода карт
    private Card[] cards;

    // конструктор создания колоды
    public Deck() {
        this.cards = new Card[36];
        fillCards();
        shuffle();

    }

    public void fillCards() {
        String[] suits = {"Пики", "Червы", "Бубны", "Трефы"};
      /*  cards[0]=new Card(2, suits[0]);
        cards[1]=new Card(3, suits[0]);
        cards[2]=new Card(4, suits[0]);
        cards[3]=new Card(5, suits[0]);

        cards[4]=new Card(2, suits[1]);
        cards[5]=new Card(3, suits[1]);
        cards[6]=new Card(4, suits[1]);
        cards[7]=new Card(5, suits[1]);

       */
        int index = 0;
        for (String suit : suits) {
            for (int cardValue = 2; cardValue <= 10; cardValue++) {
                this.cards[index++] = new Card(cardValue, suit);
            }
        }

    }
    //метод проверки пуста ли колода
    public boolean isEmpty(){
        return false;

    }

    //метод для перемешивания колоды
    public void shuffle() {
        Random random = new Random();

        for (int i = cards.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);//от 0 до 35 при 1 итерации
            Card temp = cards[index];//сохраняем элемент во временную переменную
            cards[index] = cards[i];//заменяю элемент по индексу на текущий итерируемый
            cards[i] = temp;//заменяю выбранный случайный элемент на текущий итерируемый индекс

        }

    }

    public Card[] getCards() {
        return cards;
    }

    //реализация интерфейса для перевода карт в колоду
    @Override
    public Iterator<Card> iterator() {
        return new Iterator<Card>() {
            private int curPost;
            @Override
            public boolean hasNext() {
                return curPost<cards.length;
            }

            @Override
            public Card next() {
                return cards[curPost++];
            }
        };
    }




}
