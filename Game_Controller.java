class Game_Controller
{
    Board board=new Board();
    Player player[];
    String[] player_numbers={"2nd","1st"};
    boolean status=false;
    Game_Controller()
    {
        player[1]=new Player();
        do{
        player[0]=new Player();
        }while(player[1].symbol==player[0].symbol);
        Take_Positions();
    }
    public void Take_Positions()
    {
        while(board.turns_remaining>0)
        {   int position;
            System.out.println("Enter the input : "+player_numbers[board.turns_remaining%2]+"Player");
            do{position=player[board.turns_remaining%2].getPosition();
            }while(!board.validate_entry(position, player[board.turns_remaining%2].symbol));
            if(board.Tester(position))
            {
                System.out.println(player_numbers[board.turns_remaining%2]+"Player won the game");
                return;
            }
        }
        System.out.println("Draw Match");
    }
}