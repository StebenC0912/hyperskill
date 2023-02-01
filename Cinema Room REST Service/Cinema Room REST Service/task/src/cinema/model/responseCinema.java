package cinema.model;

import java.util.ArrayList;
import java.util.List;

public class responseCinema {
    private final int total_rows;
    private final int total_columns;
    private List<Seat> available_seats = new ArrayList<>();

    public responseCinema(int total_rows, int total_columns, List<Seat> available_seats) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_seats = available_seats;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        this.available_seats = available_seats;
    }
}