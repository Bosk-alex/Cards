import java.util.*;

public class Cards {
    Map<Integer, List<Integer>> players = new HashMap<>();

    public void start(int numOfCards, int numOfPlayers) {
        if (numOfCards * numOfPlayers <= 40) {
            boolean[] handedOutCards = new boolean[40];
            Random card = new Random();
            for (int player = 1; player <= numOfPlayers; player++) {
                int count = numOfCards;
                List<Integer> cards = new ArrayList<>(numOfCards);
                while (count > 0) {
                    int temp = card.nextInt(40);
                    if (!handedOutCards[temp]) {
                        handedOutCards[temp] = true;
                        cards.add(temp + 10);
                        count--;
                    }
                }
                players.put(player, cards);
            }
        } else {
            throw new IllegalArgumentException("Not enough cards to perform the operation");
        }
    }

    public String getCards(int playerNum) {
        StringBuilder output = new StringBuilder();
        if (players.containsKey(playerNum)) {
            output.append(playerNum);
            List<Integer> cards = players.get(playerNum);
            for (Integer card : cards) {
                output.append(switch (card / 10) {
                    case 1 -> " R" + (card % 10 + 1);
                    case 2 -> " G" + (card % 10 + 1);
                    case 3 -> " B" + (card % 10 + 1);
                    case 4 -> " W" + (card % 10 + 1);

                    default -> "";
                });
            }
        } else {
            throw new IllegalArgumentException("No such player in the game");
        }
        System.out.println(output);
        return output.toString();
    }
}
