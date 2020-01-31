import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
class Board
{
    char board[]=new char[9];
    int conditions[][]={{0,1,2},{0,3,6},{0,4,8},{3,4,5},{6,7,8},{1,4,7},{2,5,8},{2,4,6}};
    int turnsRemaining=9, numberConditions=conditions.length;

    public boolean validateEntry(int position,char symbol)
    {
        if(board[position]!='\0')
            return false;
        board[position]=symbol;
        Display();
        return true;
    }

    public void Display()
    {
        System.out.println("Board is ");
        for(int row = 0;row/3<3;row+=3)
        {
            for(int column = row;(column-row)<3;column++)
                System.out.print(board[column]+"  ");
            System.out.println();
        }
    }

    public boolean Tester(int position)
    {   
        boolean isGameOver=false;
        for(int conditionPosition=0;conditionPosition<numberConditions && isGameOver==false ;conditionPosition++)
        {   
            if(isPositionInCondition(conditions[conditionPosition],position))
            {
                isGameOver=areSymbolsSame(conditionPosition);
            }
        }
        turnsRemaining--;
        return isGameOver;
    }

    public boolean areSymbolsSame(int conditionPosition)
    {
        Character[] symbolsInCondition=new Character[3];
        for(int positionInCondition=0,symbolIndex=0;positionInCondition<3;positionInCondition++,symbolIndex++)
            symbolsInCondition[symbolIndex]=board[conditions[conditionPosition][positionInCondition]];
        Set<Character> symbolSet = new HashSet<Character>(Arrays.asList(symbolsInCondition));
        if(symbolSet.size()==1)
            return true;
        return false;
    }

    public boolean isPositionInCondition(int condition[],int position)
    {
        for(int positionInCondition=0;positionInCondition<condition.length;positionInCondition++)
        {
            if(condition[positionInCondition]==position)
                return true;
        }
        return false;
    }
}