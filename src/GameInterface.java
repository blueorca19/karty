import Karty.Card;

public interface GameInterface {
    void drawCard(Card card); //добавление карты и обновления счета score
    void resetRound(); //ResetRound сброс руки и счета за раунд
    void addPointToTotalScore();//Метод для добавления балла к общему счету
}
