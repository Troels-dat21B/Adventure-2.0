public class Weapon extends Item {
    private String name;
    private String description;


    public Weapon getWeapon(){
        //Returnere våben objektet.
        return null;
    }

    public Weapon(String aName, String aDescription){//<----- fejl
        this.name = aName;
        this.description = aDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return name + "\n " +description;
    }
}