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
            if(is_position_in_condition(conditions[condition],position))
            {
                Character[] symbols_in_condition=new Character[3];
                for(int position_in_condition=0,symbol_index=0;position_in_condition<3;position_in_condition++,symbol_index++)
                    symbols_in_condition[symbol_index]=board[conditions[condition][position_in_condition]];
                Set<Character> symbol_set = new HashSet<Character>(Arrays.asList(symbols_in_condition));
                if(symbol_set.size()==1)
                    return true;
            }
        }
        turnsRemaining--;
        return false;
    }

    public boolean is_position_in_condition(int condition[],int position)
    {
        for(int iteration_variable=0;iteration_variable<condition.length;iteration_variable++)
        {
            if(condition[iteration_variable]==position)
                return true;
        }
        return false;
    }
    
}