package bleier.connect4;

public class connectBoard {

    private final double width;
    private final double height;
    private char[][] board;

    public connectBoard(double width, double height) {
        this.width = width;
        this.height = height;
        board = new char[(int)height][(int)width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public connectBoard(char[][] board) {
        this.board = board;
        this.height = board.length;
        this.width = board[0].length;
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean isFull(int col) {
        for(int i = 0; i < height; i++) {
            if(board[i][col] == ' ') { return false;}
        }

        return true;
    }

    public void insert(int col, char color) {
        color = Character.toUpperCase(color);
        if(isFull(col)) {
            System.out.println("Column is Full");
        }
        else if(color == 'R' || color == 'Y' ) {
            for(int i = 0; i < height; i++) {
                if(board[i][col] == ' ') {
                    board[i][col] = color;
                    break;
                }
            }
        }
        else {
            System.out.println("Color must be R or Y");
        }
    }

    //i feel like this inefficient
    //i should probably use hashmaps but I'm not so good at that
    //best i could come up with
    public char calcWinner() {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                char token = board[r][c];
                if (token != ' ') {

                    //check horizontal
                    if (c + 3 < width && board[r][c + 1] == token && board[r][c + 2] == token && board[r][c + 3] == token)
                        return token;

                    if (r + 3 < height) {
                        //check vertical
                        if (board[r + 1][c] == token && board[r + 2][c] == token && board[r + 3][c] == token)
                            return token;

                        //check diagnol to right
                        if (c + 3 < width && board[r + 1][c + 1] == token && board[r + 2][c + 2] == token && board[r + 3][c + 3] == token)
                            return token;

                        //check diagnol to left
                        if (c - 3 >= 0 && board[r + 1][c - 1] == token && board[r + 2][c - 2] == token && board[r + 3][c - 3] == token)
                            return token;
                    }
                }
            }
        }
        return ' ';
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                sb.append("|").append(board[i][j]).append("|");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
