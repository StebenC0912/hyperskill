package cinema.controller;


import cinema.model.Cinema;
import cinema.model.Seat;
import cinema.model.inputSeat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class controller {
    private final Cinema cinema = new Cinema(9, 9);

    @GetMapping("/seats")
    public ResponseEntity<Cinema> getAllSeat() {
        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody inputSeat inputSeat) {
        if (inputSeat.getColumn() < 0 || inputSeat.getRow() < 0 || inputSeat.getColumn() > 9 || inputSeat.getRow() > 9) {
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.valueOf(200));
        }
        List<Seat> available = cinema.getAvailable_seats();
        Seat order = inputSeat.toSeat();
        for (int i = 0; i < available.size(); i++) {
            if (available.get(i).equals(order)) {
                available.remove(i);
                cinema.setAvailable_seats(available);
                return new ResponseEntity<>(order,HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"),HttpStatus.valueOf(200));
    }
}
