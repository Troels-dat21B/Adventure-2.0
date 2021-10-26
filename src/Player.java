import java.util.ArrayList;

public class Player{
    private Room room;
    private ArrayList<Item> inventory = new ArrayList<>();





    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item){
        this.inventory.add(item);
    }

    public void removeITem(Item iTem){
        this.inventory.remove(iTem);
    }
}