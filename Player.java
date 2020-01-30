import java.util.Scanner;
class Player
{
    Scanner scanner = new Scanner(System.in);
    char symbol;
    Player()
    {
        System.out.println("Enter the Symbol : ");
        String temperory_symbol=scanner.next();
        symbol=temperory_symbol.charAt(0);
    }
    public int getPosition()
    {
        int position=scanner.nextInt();
        return position;
    }
}