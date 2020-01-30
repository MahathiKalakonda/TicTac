import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
class Board
{
    char board[]=new char[9];
    int turns_remaining=9;
    int conditions[][]={{0,1,2},{0,3,6},{0,4,8},{3,4,5},{6,7,8},{1,4,7},{2,5,8},{2,4,6}};
    public boolean validate_entry(int position,char symbol)
    {
        if(board[position]!='\0')
            return false;
        board[position]=symbol;
        turns_remaining--;
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
        int number_conditions=8;
        for(int condition=0;condition<number_conditions && is_position_in_condition(conditions[condition],position);condition++)
        {   Character[] symbols_in_condition=new Character[3];
            for(int position_in_condition=0,symbol_index=0;position_in_condition<3;position_in_condition++,symbol_index++)
                symbols_in_condition[symbol_index]=board[conditions[condition][position_in_condition]];
            Set<Character> symbol_set = new HashSet<Character>(Arrays.asList(symbols_in_condition));
            if(symbol_set.size()==1)
                return true;
        }
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