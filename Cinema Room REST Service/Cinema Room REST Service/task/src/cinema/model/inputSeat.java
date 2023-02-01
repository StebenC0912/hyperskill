package cinema.model;

public class inputSeat {
    private int row;
    private int column;

    public inputSeat(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public Seat toSeat() {
        int price = this.row <= 4 ? 10 : 8;
        return new Seat(row,column,price);
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
