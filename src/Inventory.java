import java.util.ArrayList;

public class Inventory{
    Item item = new Item();
    private ArrayList<Item> items = new ArrayList<>();
    Colors color = new Colors();

    public Inventory(){}

    public Inventory(int i) {

        switch (i) {
            case 1:
                inv1();
                break;
            case 2:
                inv2();
                break;
            case 3:
                inv3();
                break;
            case 4:
                inv4();
                break;
            default:

                System.out.println(color.red() + "DEBUG: Der er ikke oprettet inventory for dette nummer. Check om du har indtastet rigtig værdi." + color.resetText() );
        }
    }

    public void addItems(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }


    private ArrayList<Item> inv1() {
        return items;
    }

    private ArrayList<Item> inv2() {


        return items;
    }

    private ArrayList<Item> inv3() {


        return items;
    }

    private ArrayList<Item> inv4() {


        return items;
    }

}