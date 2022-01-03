public class State {
    private int[] board;
    private int player;
    private boolean terminal;
    private int winner;

    public State() {
        this.board = new int[]{0,0,0,0,0,0,0,0,0};
        this.player = 1;
        this.terminal = false;
    }
    public void nextPlayer(){
        this.player *= -1;
    }
    public void advance(int index){
        if(!isLegal(index) || terminal || isFull()) return;
        board[index] = player;
        this.terminal = isGameOver();
        nextPlayer();
    }
    private boolean isLegal( int n){
        return board[n] == 0;
    }
    public boolean isGameOver(){
        if(isEqual(0, 1,2))return true;
        if(isEqual(3, 4,5))return true;
        if(isEqual(6, 7,8))return true;
        if(isEqual(0, 3,6))return true;
        if(isEqual(1, 4,7))return true;
        if(isEqual(2, 5,8))return true;
        if(isEqual(0, 4,8))return true;
        if(isEqual(2, 4,6))return true;
        return false;
    }

    public boolean isEqual(int a, int b, int c){
        if(board[a] == board[b]  && board[a]  == board[c] && board[a] != 0 ){
            winner = player;
            return true;
        }
        return false ;
    }

    public boolean isFull(){
        for(int i : board){
            if(i == 0) return false;
        }
        return true;
    }

    public int[] getBoard(){
        return board;
    }
    public int getWinner(){
        return winner;
    }
}
