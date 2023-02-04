package cinema.model;

public class InputSeat {
    private final int row;
    private final int column;

    public InputSeat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Seat toSeat() {
        int price = this.row < 5 ? 10 : 8;
        return new Seat(this.row, this.column, price);
    }
}
