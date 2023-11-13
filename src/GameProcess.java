import Karty.Card;

import java.util.Iterator;
import java.util.Scanner;

public class GameProcess {
    private Scanner scanner;
    private Deck deck;
    private Player player;
    private Iterator<Card> cardIterator;

    public static void main(String[] args) {
        GameProcess gameProcess = new GameProcess();//запуск игры
        gameProcess.startGame(); //вызван метод начала игры
    }


    public GameProcess() {
        this.scanner = new Scanner(System.in);
        this.deck = new Deck();
       if (deck.isEmpty()) {
            System.out.println("Карты в колоде закончились. Игра завершена.");
            System.exit(0);
       }
        this.player = new Player(getPlayerName());
        this.cardIterator = deck.iterator();
    }

    private String getPlayerName() {
        System.out.println("Введите ваше имя: ");
        return scanner.nextLine();
    }

    public void startGame() { // Метод для начала игры
        boolean gameInProgress = true;

//        while (gameInProgress) {
            Iterator<Card> cardIterator = deck.iterator(); // Итератор по колоде карт

            while (cardIterator.hasNext()) {
                System.out.println("Хотите начать новый раунд?");
                String inPut= scanner.nextLine();
                if (inPut.equals("e")){
                    break;
                }

                if (player.getScore() >= 21) {
                    handleRoundEnd(); // Обработка завершения раунда
                } else if (drawAdditionalCard()) { // Если игрок не хочет брать дополнительные карты, выходим из цикла
                    Card card = cardIterator.next(); // Получение следующей карты
                    player.drawCard(card);// Добавление карты игрок
                    System.out.println("Вы получили карту: " + card); // Вывод информации о полученной карте

                }
            }
//        }

        System.out.println("Игра завершена. Общий счет игрока: " + player.getTotalScore());


        scanner.close();
    }
    // Метод для обработки завершения раунда

    private void handleRoundEnd() {
        if (player.getScore() == 21) {
            player.addPointToTotalScore();
            System.out.println("Поздравляем! Вы набрали 21 балл. Выигрыш в этом раунде!");
        } else {
            System.out.println("Превышено 21 балл. Вы проиграли в этом раунде.");
        }
        player.resetRound();
    }
    // Метод для запроса игрока о том, брать ли ему дополнительные карты
    private boolean drawAdditionalCard() {
        String drawChoice;
        do {
            System.out.println("Хотите взять еще карту? (y) или завершить раунд? (e)");
            drawChoice = scanner.nextLine();
        } while (!drawChoice.equals("y") && !drawChoice.equals("e"));

        return drawChoice.equals("y");
    }
    // Метод для запроса игрока о том, начать ли новый раунд или завершить игру
    private boolean startNewRound() {
        if (deck.isEmpty()) {
            System.out.println("Карты в колоде закончились. Игра завершена.");
            return false;}

        String newGameChoise;
        do {
            System.out.println("Хотите начать новый раунд? (y/e)");
            newGameChoise = scanner.nextLine();
        } while (!newGameChoise.equals("y") && !newGameChoise.equals("e"));

        if (newGameChoise.equals("y")) {
            if (!cardIterator.hasNext()) {
                System.out.println("Карты в колоде закончились. Игра завершена.");
                return false;
            }
        }



        return true;
    }
}




