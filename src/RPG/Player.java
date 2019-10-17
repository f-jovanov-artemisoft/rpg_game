package RPG;

public class Player {
    private Character Mage = new Character(100, 2, 1, 0, 0, 5, "M", "Magic");
    private Character Hunter = new Character(85, 3, 1, 0, 1, 3, "H", "Physical");
    private Character Warrior = new Character(200, 1, 1, 1, 1, 7, "W", "Physical");
    private Character Cavalry = new Character(170,1,2,1,0,5,"C","Physical");
    private String name;


    public Player(String name){
        this.name = name;
    }

    public Character getChar(String name){
        if(name.equals(Mage.getName())){
            return Mage;
        }
        else if(name.equals(Hunter.getName())){
            return Hunter;
        }
        else if(name.equals(Warrior.getName())){
            return Warrior;
        }
        else if(name.equals(Cavalry.getName())){
            return Cavalry;
        }
        return new Character();
    }

    public String getName(){
        return name;
    }

}