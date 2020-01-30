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
}