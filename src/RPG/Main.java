package RPG;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        String choice;
        int x,y;
        Player current_player,other_player;
        Character current_character;

        Board board = new Board();
        Player player1 = new Player("Pazzio");
        Player player2 = new Player("Tester Bot");
        Scanner in = new Scanner(System.in);


        board.setPlayers(player1,"1");
        board.setPlayers(player2,"2");
        while(true){

            board.printBoard();
            System.out.println("Which player would you like to play this turn?");
            choice = in.nextLine();
            if(player1.getName().equals(choice)){
                current_player = player1;
                other_player = player2;
            }else{
                current_player = player2;
                other_player = player1;
            }
            System.out.println("Which character would you like to play for this turn?");

            choice = in.nextLine();
            current_character = current_player.getChar(choice);
            System.out.println("Would you like to defend or attack? (ATT/DEF)");
            choice = in.nextLine();

            if(choice.equals("ATT")){
                System.out.println("Would you like to move, or attack? (M/A)");
                choice = in.nextLine();
                if(choice.equals("M")){
                    Move(board,current_character);
                }else if(choice.equals("A")){
                    AttackFinal(board,current_character,other_player);
                }
            }else if(choice.equals("DEF")){
               current_character.setDef();

            }
        }
    }

    private static void Move(Board board, Character current_character){
        Scanner in = new Scanner(System.in);
        System.out.println("How much lower(negative if higher): ");
        int x = in.nextInt();
        System.out.println("How many positions right(negative if left): ");
        int y = in.nextInt();
        boolean z = board.moveCharacter(current_character,x,y);
        if(!z){
            Move(board,current_character);
        }
    }

    private static void AttackFinal(Board board, Character current_character, Player player2){
        Scanner in = new Scanner(System.in);
        System.out.println("Which character do you wanna attack?");
        String choice = in.nextLine();
        boolean z = board.AttackMove(current_character,player2.getChar(choice));
//        if(!z){
//            AttackFinal(board,current_character,player2);
//        }
    }

}