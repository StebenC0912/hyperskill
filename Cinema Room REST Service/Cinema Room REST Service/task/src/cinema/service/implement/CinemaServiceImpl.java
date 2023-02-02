package cinema.service.implement;

import cinema.model.Cinema;
import cinema.model.Seat;
import cinema.model.inputSeat;
import cinema.model.responseCinema;
import cinema.service.CinemaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final Cinema cinema = new Cinema(9, 9);

    @Override
    public responseCinema getAllSeat() {
        return cinema.toResponse();
    }

    @Override
    public Seat purchase(inputSeat inputseat) throws Exception {
        Seat seat = inputseat.toSeat();
        if (seat.getColumn() < 0 || seat.getRow() < 0 || seat.getColumn() > 9 || seat.getRow() > 9) {
            throw new IndexOutOfBoundsException("The number of a row or a column is out of bounds!");
        }
        char[][] seatAvailable = cinema.getSeat();
        if (seatAvailable[seat.getRow()][seat.getColumn()] != 'T') {
            throw new Exception("The ticket has been already purchased!");
        }
        seatAvailable[seat.getRow()][seat.getColumn()] = 'O';
        cinema.setSeat(seatAvailable);
        List<Seat> available = cinema.getAvailable_seats();
        return available.get(available.indexOf(seat));
    }
}
