public class Player{
    private Room room;
    private Inventory inventory;



    public Player(Room aRoom){
        this.room = aRoom;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }



}