package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Card {
    String kind;
    int id;
    int resource;

    public Card(String kind, int id, int resource) {
        this.kind = kind;
        this.id = id;
        this.resource = resource;
    }

    public String getKind() {
        return kind;
    }

    public int getId() {
        return id;
    }

    public int getResource() {
        return resource;
    }
}



class Manager {

    private final GameState gameState;

    public Manager(Deque<Card> deck, int peopleNum) {
        this.gameState = new GameState(deck, peopleNum);
    }

    public int doTrun(int people) {
        Card curCard = gameState.getCurCard(people);

        switch (curCard.getKind()) {
            case "next":
                gameState.discardCard(people);
                break;
            case "acquire":
                if (!gameState.resourceCheck(curCard.getResource())) {
                    gameState.resourceAdd(curCard.getResource());
                    gameState.discardCard(people);
                }

                break;

            case "release":
                gameState.resourceRemove(curCard.getResource());
                gameState.discardCard(people);
                break;
        }

        return curCard.getId();

    }

    static class GameState {

        private final HashSet<Integer> resource = new HashSet<>();
        private final Card[] peopleKeepCard;
        private final Deque<Card> deck;

        GameState(Deque<Card> deck, int peopleNum) {
            this.deck = deck;
            this.peopleKeepCard = new Card[peopleNum + 1];
        }

        public Card getCurCard(int people) {
            if (peopleKeepCard[people] == null) {
                peopleKeepCard[people] = deck.pollFirst();
            }
            return peopleKeepCard[people];
        }

        public void discardCard(int people) {
            peopleKeepCard[people] = null;
        }

        public boolean resourceCheck(int param) {
            return resource.contains(param);
        }

        public void resourceAdd(int param) {
            resource.add(param);
        }

        public void resourceRemove(int param) {
            resource.remove(param);
        }
    }

}



public class baekjoon21775 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] games = new int[t];
        Deque<Card> cList = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < t; i++){
            games[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int id = Integer.parseInt(st.nextToken());
            String kind = st.nextToken();
            int resource = kind.equals("next") ? -1 : Integer.parseInt(st.nextToken());

            cList.add(new Card(kind, id, resource));

        }

        Manager manager = new Manager(new ArrayDeque<>(cList), n);

        for (int i = 0; i < t; i++){

            int x = manager.doTrun(games[i]);

            System.out.println(x);

        }


    }


}
