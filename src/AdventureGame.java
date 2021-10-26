
import java.util.Locale;
import java.util.Scanner;

public class AdventureGame {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isWalid = true;
        boolean gameIsRunning = true;
        Map map = new Map(1);
        Colors color = new Colors();
        Player player = new Player();

        Room currentRoom = map.getStarterRoom();
        player.setRoom(currentRoom);


        System.out.println("Welcome to KEA adventure game.");
        System.out.println("To move around the different room´s you have to type: ");
        System.out.println(""" 
                go north
                go south
                go east
                or go west
                take
                drop
                inventory/inv
                """);
        System.out.println("For informations type " + '"' + "help" + '"');
        System.out.println("Lets begin ;) ");
        System.out.println(currentRoom);


        while (gameIsRunning) {
            System.out.println("Type a command");

            String input = scanner.nextLine();
            do {
                if (input.equalsIgnoreCase("Go south") ||
                        input.equalsIgnoreCase("Go east") ||
                        input.equalsIgnoreCase("Go west") ||
                        input.equalsIgnoreCase("Go north") ||
                        input.equalsIgnoreCase("Exit") ||
                        input.equalsIgnoreCase("Help") ||
                        input.equalsIgnoreCase("Look") ||
                        input.equalsIgnoreCase("Take") ||
                        input.equalsIgnoreCase("Drop") ||
                        input.equalsIgnoreCase("Inventory")||
                        input.equalsIgnoreCase("Inv")) {


                    isWalid = true;

                } else {
                    System.out.println(color.red() + "ikke gyldigt svar" + color.resetText());
                }
            } while (!isWalid);

            switch (input.toLowerCase(Locale.ROOT)) {
                case "exit":
                    System.out.println("Bye");
                    gameIsRunning = false;
                    break;
                case "help":
                    System.out.println("""
                            - go north
                            - go south
                            - go east
                            - go west
                            - exit: You can exit the game at any moment by typing "exit".
                            - look: When you type "look" you will get a description of the room.
                            - help: When you are typing "help" this list will come.
                            - take/take all: Take a single item or all items in the room.
                            - drop: to drop an item from inventory
                            - inventory/inv
                            """);
                    break;
                case "look":
                    System.out.println(currentRoom);
                    if(currentRoom.getInventory().size() == 0){
                        System.out.println("This place don't have items to take");
                    }else{
                        System.out.println("This place offers these items");
                        System.out.println(currentRoom.getInventory());
                    }
                    break;

                case "go north":
                    if (currentRoom.getNorth() == null) {
                        System.out.println(color.red() + "The northern gate is closed" + color.resetText());
                        break;
                    }
                    currentRoom = currentRoom.getNorth();
                    System.out.println(currentRoom);
                    break;

                case "go south":
                    if (currentRoom.getSouth() == null) {
                        System.out.println(color.red() + "The southern gate is closed" + color.resetText());
                        break;
                    }
                    currentRoom = currentRoom.getSouth();
                    System.out.println(currentRoom);
                    break;

                case "go east":
                    if (currentRoom.getEast() == null) {
                        System.out.println(color.red() + "The eastern gate is closed" + color.resetText());
                        break;
                    }
                    currentRoom = currentRoom.getEast();
                    System.out.println(currentRoom);
                    break;

                case "go west":
                    if (currentRoom.getWest() == null) {
                        System.out.println(color.red() + "The western gate is closed" + color.resetText());
                        break;
                    }
                    currentRoom = currentRoom.getWest();
                    System.out.println(currentRoom);
                    break;

                case "take":
                    if(currentRoom.getInventory().size() == 0){
                        System.out.println("This place does not have any items...");
                        break;
                    }
                    System.out.println("What would you like to take?");
                    input = scanner.nextLine();
                    for(int i = 0; i < currentRoom.getInventory().size(); i++){
                        if(input.equalsIgnoreCase(currentRoom.getInventory().get(i).toString())){
                            player.addItem(currentRoom.getInventory().get(i));
                            currentRoom.removeITem(currentRoom.getInventory().get(i));
                        }
                    }
                    break;
                case "take all":
                    if(currentRoom.getInventory().size() == 0){
                        System.out.println("This place does not have any items...");
                        break;
                    }
                    for(int i = 0; i < currentRoom.getInventory().size(); i++){
                        player.addItem(currentRoom.getInventory().get(i));
                    }
                case "drop":
                    if(player.getInventory().size() == 0){
                        System.out.println("Inventory is empty...");
                        break;
                    }
                    System.out.println("What would you like to drop?");
                    input = scanner.nextLine();
                    for(int i = 0; i < player.getInventory().size(); i++){
                        if(input.equalsIgnoreCase(player.getInventory().get(i).toString())){
                            currentRoom.addItem(player.getInventory().get(i));
                            player.removeITem(player.getInventory().get(i));
                        }
                    }
                    break;
                case "inventory":
                case "inv":
                    System.out.println(player.getInventory());
                    break;

            }
        }
    }
}

