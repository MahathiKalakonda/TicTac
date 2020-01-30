import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
class Board
{
    char board[]=new char[9];
    int turnsRemaining=9, numberConditions=8;
    int conditions[][]={{0,1,2},{0,3,6},{0,4,8},{3,4,5},{6,7,8},{1,4,7},{2,5,8},{2,4,6}};

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
            {
                System.out.print(board[column]+"  ");
            }
            System.out.println();
        }
    }

    public boolean Tester(int position)
    {
        for(int condition=0;condition<numberConditions;condition++)
        {   
            if(isPositionInCondition(conditions[condition],position))
            {
                Character[] symbolsInCondition=new Character[3];
                for(int positionInCondition=0,symbolIndex=0;positionInCondition<3;positionInCondition++,symbolIndex++)
                    symbolsInCondition[symbolIndex]=board[conditions[condition][positionInCondition]];
                Set<Character> symbolSet = new HashSet<Character>(Arrays.asList(symbolsInCondition));
                if(symbolSet.size()==1)
                    return true;
            }
        }
        turnsRemaining--;
        return false;
    }

    public boolean isPositionInCondition(int condition[],int position)
    {
        for(int iterationVariable=0;iterationVariable<condition.length;iterationVariable++)
        {
            if(condition[iterationVariable]==position)
                return true;
        }
        return false;
    }

}