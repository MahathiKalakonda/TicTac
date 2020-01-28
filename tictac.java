import java.util.Scanner;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

import java.lang.Math;
class tictac
{	static int board[][]=new int[3][3];
	public static boolean test(int row,int column,int symbol)
	{
		if(checkRow(row,column,symbol))
			return true;
		if(checkColumn(row,column,symbol))
			return true;
		if(row==column)
            if(checkTopRightDiagonal(row,column,symbol))
        		return true;
		if((row==1 && column ==1)||(Math.abs(row-column)==2))
			if(checkTopLeftDiagonal(row,column,symbol))
				return true;
		return false;
	}
	public static boolean checkRow(int row,int column,int symbol)
	{
		if(board[(row-1+3)%3][column]==symbol && board[(row-2+3)%3][column]==symbol)
			return true;
		return false;
	}
	public static boolean checkColumn(int row,int column,int symbol)
	{
		if(board[row][(column-1+3)%3]==symbol && board[row][(column-2+3)%3]==symbol)
			return true;
		return false;
	}
	public static boolean checkTopRightDiagonal(int row,int column,int symbol)
	{
		if(board[(row-1+3)%3][(column-1+3)%3]==symbol && board[(row-2+3)%3][(column-2+3)%3]==symbol)
			return true;
		return false;
	}
	public static boolean checkTopLeftDiagonal(int row,int column,int symbol)
	{
		if(board[(row+1+3)%3][(column-1+3)%3]==symbol && board[(row+2+3)%3][(column-2+3)%3]==symbol)
			return true;
		return false;
	}
	public static void Display()
	{
		System.out.println("The grid is : ");
		for(int row=0;row<3;row++)
		{
			for(int column=0;column<3;column++)
			{
				System.out.print(board[row][column]+"  ");
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int filled=0;
		boolean Status=false;
		while(filled<9)
		{	
			System.out.println("Enter position of player"+((filled%2)+1));
			System.out.println("Row : ");
			int row=in.nextInt();
			System.out.println("Column : ");
			int col=in.nextInt();
			if(board[row-1][col-1]!=0)
			{
				System.out.println("Position is already filled, Please enter another position ");
			}
			else
			{
				board[row-1][col-1]=(filled%2)+1;
				Status=test(row-1,col-1,(filled%2)+1);
				Display();
				if(Status)
				{
					System.out.println("Player"+((filled%2)+1)+" won the game");
					break;
				}
				filled++;
			}
		}
		if(filled==9)
			System.out.println("Draw Match");
	}	
}