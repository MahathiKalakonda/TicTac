class GameController
{
    Board board=new Board();
    Player players[]=new Player[2];
    String[] playerNumbers={"2nd","1st"};
    boolean status=false;
    int position;

    public void startGame()
    {
        players[1]=new Player('X');
        players[0]=new Player('O');
        takePositions();
    }

    public void takePositions()
    {
        while(board.turnsRemaining>0)
        {   
            do
                position=players[board.turnsRemaining%2].getPosition(playerNumbers[board.turnsRemaining%2]);
            while(!board.validateEntry(position, players[board.turnsRemaining%2].symbol));
            if(board.Tester(position))
            {
                System.out.println(playerNumbers[(board.turnsRemaining+1)%2]+"Player won the game");
                return;
            }
        }
        System.out.println("Draw Match");
    }

}