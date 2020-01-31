class GameController
{
    Board board=new Board();
    Player players[]=new Player[2];
    String[] playerNumbers={"2nd","1st"};
    boolean status=false;
    int position;

    GameController()
    {
        players[1]=new Player('X');
        players[0]=new Player('O');
    }

    public void startGame()
    {
        while(board.turnsRemaining>0)
        {
            takePositions();
            status=board.Tester(position);
            if(status)
                break;
        }
        displayStatus();
    }

    public void takePositions()
    {
        do
            position=players[board.turnsRemaining%2].getPosition(playerNumbers[board.turnsRemaining%2]);
        while(!board.validateEntry(position, players[board.turnsRemaining%2].symbol));
    }

    public void displayStatus()
    {
        if(status)
            System.out.println(playerNumbers[(board.turnsRemaining+1)%2]+"Player won the game");
        else
            System.out.println("Draw Match");
    }
}