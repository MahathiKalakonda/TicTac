import java.util.Scanner;
class Player
{
    Scanner scanner = new Scanner(System.in);
    char symbol;

    Player(char symbol)
    {
        this.symbol=symbol;
    }

    public int getPosition(String playerName)
    {
        System.out.println("Enter the input : "+playerName+"Player");
        int position=scanner.nextInt();
        return position;
    }
}