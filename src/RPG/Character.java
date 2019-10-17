package RPG;

public class Character {
    private int health,range,move,magic_def,physical_def,dmg,x,y;
    private String dmg_type;
    private String name;
    private boolean invulnerable,alive;

    public Character(int health,int range, int move, int magic_def, int physical_def,int dmg,String name, String dmg_type){
        this.name = name;
        this.dmg = dmg;
        this.health = health;
        this.range = range;
        this.move = move;
        this.magic_def = magic_def;
        this.physical_def = physical_def;
        this.dmg_type = dmg_type;
        this.invulnerable = false;
        this.x = 0;
        this.y = 0;
        this.alive = true;
    }

    public Character(){

    }

    public void setName(String newName){
        this.name = newName;
    }

    public boolean isDef(){
        return invulnerable;
    }

    public void setDef(){
        invulnerable = true;
    }

    public int physDamaged(int dmg_dealt){
        this.health = this.health - (dmg_dealt - this.physical_def);
        return dmg_dealt - this.physical_def;
    }

    public int magicDamaged(int dmg_dealt){
        this.health =this.health - (dmg_dealt - this.magic_def);
        return dmg_dealt - this.magic_def;
    }

    public int Attack(){
        return dmg;
    }

    public String getName(){
        return name;
    }

    public int getRange(){
        return range;
    }

    public String getType(){
        return dmg_type;
    }
    public int getHealth(){
        return health;
    }


    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getMove(){
        return move;
    }
    public boolean getAlive(){
        return alive;
    }

    public void hasDieded(){
        this.alive = false;
    }
}
