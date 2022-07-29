
package alias;

public class User {
    private int id;
    private String name;
    private Card card;
    private BonusCard bonuscard;

    public User(int id, String name, Card card, BonusCard bonuscard) {
        this.id = id;
        this.name = name;
        this.card = card;
        this.bonuscard = bonuscard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Card getCard() {
        return card;
    }

    public BonusCard getBonuscard() {
        return bonuscard;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setBonuscard(BonusCard bonuscard) {
        this.bonuscard = bonuscard;
    }
    
    
}

