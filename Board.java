class Board
{
    char board[]=new char[9];
    int turns_remaining=9;
    public boolean validate_entry(int position,char symbols[])
    {
        if(board[position]!='\0')
            return false;
        board[position]=symbols[turns_remaining%2];
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
}