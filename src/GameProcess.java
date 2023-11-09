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

    public void startGame() {
        boolean gameInProgress = true;

        while (gameInProgress) {
            Iterator<Card> cardIterator = deck.iterator();
            player.resetRound();

            while (cardIterator.hasNext() && player.getScore() < 21) {
                Card card = cardIterator.next();
                player.drawCard(card);
                System.out.println("Вы получили карту: " + card);

                if (player.getScore() >= 21) {
                    handleRoundEnd();
                    if (!startNewRound()) {
                        gameInProgress = false;
                        break;
                    }
                } else if (!drawAdditionalCard()) {
                    break;
                }
            }

            if (!cardIterator.hasNext() || !startNewRound()) {
                gameInProgress = false;
            }
        }

        scanner.close();
    }

    private void handleRoundEnd() {
        if (player.getScore() == 21) {
            player.addPointToTotalScore();
            System.out.println("Поздравляем! Вы набрали 21 балл. Выигрыш в этом раунде!");
        } else {
            System.out.println("Превышено 21 балл. Вы проиграли в этом раунде.");
        }
        player.resetRound();
    }

    private boolean drawAdditionalCard() {
        String drawChoice;
        do {
            System.out.println("Хотите взять еще карту? (y) или завершить раунд? (e)");
            drawChoice = scanner.nextLine();
        } while (!drawChoice.equals("y") && !drawChoice.equals("e"));

        return drawChoice.equals("y");
    }

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
        } else {
            System.out.println("Игра завершена. Общий счет игрока: " + player.getTotalScore());
            return false;
        }

        return true;
    }
}




