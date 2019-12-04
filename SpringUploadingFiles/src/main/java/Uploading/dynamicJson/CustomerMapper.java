package Uploading.dynamicJson;


import java.util.HashMap;
import java.util.Map;

public class CustomerMapper {

    private String id;
    private Map<String, CardsMapper> cards = new HashMap<>();

    public Map<String, CardsMapper> getCards() {
        return cards;
    }

    public void setCards(Map<String, CardsMapper> cards) {
        this.cards = cards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
