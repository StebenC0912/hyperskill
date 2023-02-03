package cinema.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;

@EntityScan
public class Cinema {
    private int total_rows;
    private int total_columns;
    private List<Seat> available_seats = new ArrayList<>();


    public Cinema(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        generateSeat(total_rows, total_columns);
    }

    public void generateSeat(int row, int col) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                int price = i <= 4 ? 10 : 8;
                this.available_seats.add(new Seat(i, j, price));
            }
        }
    }
    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        this.available_seats = available_seats;
    }

    @Override
    public String toString() {
        return "cinema{" +
                "total_rows=" + total_rows +
                ", total_columns=" + total_columns +
                ", available_seats=" + available_seats +
                '}';
    }
}
