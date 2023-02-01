package cinema.controller;



import cinema.model.inputSeat;
import cinema.model.responseCinema;
import cinema.model.Seat;
import cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Autowired
    private CinemaService cinemaService;


    @GetMapping("/seats")
    public ResponseEntity<responseCinema> getAllSeat() {
        return new ResponseEntity<>(cinemaService.getAllSeat(),HttpStatus.OK);
    }
    @PostMapping("/purchase")
    public ResponseEntity<Seat> purchase (@RequestBody inputSeat seat) throws Exception {
        return new ResponseEntity<>(cinemaService.purchase(seat), HttpStatus.CREATED);
    }
}
