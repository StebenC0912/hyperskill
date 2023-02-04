package cinema.controller;

import cinema.model.Cinema;
import cinema.model.InputSeat;
import cinema.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    private Cinema cinema = new Cinema(9, 9);

    @GetMapping("/seats")
    public Cinema getAllSeat() {
        return cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody InputSeat inputSeat) {
        if (inputSeat.getRow() < 0 || inputSeat.getColumn() < 0 || inputSeat.getRow() > 9 || inputSeat.getColumn() > 9)
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.OK);
        List<Seat> availableSeat = cinema.getAvailable_seats();
        Seat orderSeat = inputSeat.toSeat();
        for (int i = 0; i < availableSeat.size(); i++) {
            if (availableSeat.get(i).equals(orderSeat)) {
                availableSeat.remove(i);
                cinema.setAvailable_seats(availableSeat);
                return new ResponseEntity<>(orderSeat, HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.OK);

    }
}
