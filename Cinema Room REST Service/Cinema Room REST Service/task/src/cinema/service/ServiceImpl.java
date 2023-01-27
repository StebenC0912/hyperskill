package cinema.service;

import cinema.model.Cinema;
import cinema.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ServiceImpl implements Service{
    @Autowired
    private Cinema cinema = new Cinema(9,9);
    @Override
    public Cinema getAllSeat() {
        return cinema;
    }

    @Override
    public Seat purchase(Seat seat) throws Exception {
        if (seat.getColumn() < 0 || seat.getRow() < 0 ||seat.getColumn() > 9 || seat.getRow() > 9) {
            throw new Exception("The number of a row or a column is out of bounds!");
        }
        char[][] seatAvailable = cinema.getSeat();
        if (seatAvailable[seat.getRow()][seat.getColumn()] != 'T') {
            throw new Exception("The ticket has been already purchased!");
        }
        seatAvailable[seat.getRow()][seat.getColumn()] = 'O';
        List<Seat> available = cinema.getAvailable_seats();
        return available.get(available.indexOf(seat));
    }

}
