import java.util.ArrayList;

public class Inventory{
    Item item = new Item();
    private ArrayList<Item> items = new ArrayList<>();
    Colors color = new Colors();

    public Inventory(){}



    public void addItems(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }




}