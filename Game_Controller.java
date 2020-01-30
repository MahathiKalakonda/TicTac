class GameController
{
    Board board=new Board();
    Player players[]=new Player[2];
    players[0]=new Player('O');
    players[1]=new Player('X');
    String[] playerNumbers={"2nd","1st"};
    boolean status=false;

    public void startGame()
    {
        takePositions();
    }

    public void takePositions()
    {
        while(board.turnsRemaining>0)
        {   int position;
            do{System.out.println("Enter the input : "+playerNumbers[board.turnsRemaining%2]+"Player");
                position=players[board.turnsRemaining%2].getPosition();
            }while(!board.validateEntry(position, players[board.turnsRemaining%2].symbol));
            board.Display();
            if(board.Tester(position))
            {
                System.out.println(playerNumbers[board.turnsRemaining%2]+"Player won the game");
                return;
            }
        }
        System.out.println("Draw Match");
    }

}