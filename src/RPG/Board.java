package RPG;

import java.util.Arrays;
import java.util.Random;

public class Board {
    private String[][] mapArray = new String[10][10];
    private Random random = new Random();

    public Board(){
        for(int i=0;i<10;i++) {
            Arrays.fill(mapArray[i], "*");
        }
    }


    public void setCharacter(Character character){
        int x = random.nextInt(10);
        int y = random.nextInt(10);

        if(mapArray[x][y].equals("*")) {
            mapArray[x][y] = character.getName();
            character.setPosition(x,y);
        }else{
            System.out.println("Repeated!");
            this.setCharacter(character);
        }
    }

    public void printBoard(){
        for(int i=0;i<10;i++){
            System.out.println(String.join("   ",mapArray[i]));
        }
    }


    public void setPlayers(Player player,String n){
        String[] names = {"M","C","W","H"};
        for(int i=0;i<4;i++) {
            player.getChar(names[i]).setName(player.getChar(names[i]).getName() + n);
            this.setCharacter(player.getChar(names[i] + n));
        }

    }


    public boolean moveCharacter(Character character, int x, int y) {
        int char_x = character.getX(), char_y = character.getY();
        if (char_x + x > 10 || char_y + y > 10 || char_x + x < 0 || char_y + y < 0) {
            System.out.println("Out of bounds!");
            return false;
        } else if (character.getMove() >= x && -character.getMove() <= x
                && character.getMove() >= y && -character.getMove() <= y) {
            if(mapArray[char_x + x][char_y + y].equals("*")){
                mapArray[char_x][char_y] = "*";
                mapArray[char_x + x][char_y + y] = character.getName();
                character.setPosition(char_x + x,char_y + y);
                return true;
            }else{
                System.out.println("There is already someone there!");
                return false;
            }

        } else {
            System.out.println("Try other values please!");
            return false;
        }
    }

        public boolean AttackMove(Character attacker , Character attacked){
            int x = 0;
            if(attacked.getAlive()) {
                if (attacker.getRange() + attacker.getX() >= attacked.getX() && attacker.getX() - attacker.getRange() <= attacked.getX()
                        && attacker.getRange() + attacker.getY() >= attacked.getY() && attacker.getY() - attacker.getRange() <= attacked.getY()) {

                    if (attacked.isDef()) {
                        System.out.println("He's defending!");
                        return false;
                    } else {
                        if (attacker.getType().equals("Physical")) {
                            x = attacked.physDamaged(attacker.Attack());

                        } else if (attacker.getType().equals("Magic")) {
                            x = attacked.magicDamaged(attacker.Attack());
                        }
                        if (attacked.getHealth() > 0) {
                            System.out.println("Damaged for " + x + ", attacked now has " + attacked.getHealth());
                        } else if (attacked.getHealth() <= 0) {
                            mapArray[attacked.getX()][attacked.getY()] = "*";
                            attacked.hasDieded();
                            System.out.println("You killed his unit!");
                        }
                    }

                } else {
                    System.out.println("You aren't in range sadly!");
                    return false;
                }
            }else{
                System.out.println("Leave the dead alone :c");
                attacker.physDamaged(20);
                System.out.println("If you beat a dead horse with a stick enough times, it'll get annoyed and wake up" +
                        "from the dead and beat the s#!* out of you. That happened at the moment.");

                return false;
            }
        return true;
    }

}
