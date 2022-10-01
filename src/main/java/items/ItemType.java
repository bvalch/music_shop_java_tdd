package items;

public enum ItemType {

    GUITAR_PICK("Guitar Pick",10),
    GUITAR_STRING("Guitar Strings",15),
    PIANO_KEY("Piano Key",20),
    DRUM_STICKS("Not Chicken",20);

    private String name;
    private int price;

    ItemType(String name, int price) {
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
