import Karty.Card;
import org.junit.jupiter.api.*;

@DisplayName("Тестирование колоды")
public class DeckTest {
    private Deck deck;



    @BeforeEach
    void setUp(){
        deck=new Deck();

    }

    @Test
    public void test_fillArray(){
        deck.fillCards();
       Card[] cards = deck.getCards();

       for (Card card :cards){
           Assertions.assertNotNull(card);
       }

    }
    @Test
    public void test_shuffle(){
        deck.fillCards();
        Card[] cards = deck.getCards();
        deck.shuffle();
        Card[] shuffleCards = deck.getCards();
        System.out.println();

    }

}
