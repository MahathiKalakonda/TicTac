class Board
{
    char board[]=new char[9];
    int turns_remaining=9;
    int conditions[][]=new int[8][3];
    conditions={{0,1,2},{0,3,6},{0,4,8},{3,4,5},{6,7,8},{1,4,7},{2,5,8},{2,4,6}};
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
        char 
        for(int condition=0;condition<number_conditions;condition++)
        {

        }
        return false;
    }
}