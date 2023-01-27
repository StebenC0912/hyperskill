package cinema.controller;



import cinema.model.Cinema;
import cinema.model.Seat;
import cinema.service.Service;
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
    private Service service;


    @GetMapping("/seats")
    public ResponseEntity<Cinema> getSeat() {
        return new ResponseEntity<>(service.getAllSeat(), HttpStatus.OK);
    }
    @PostMapping("/purchase")
    public ResponseEntity<Seat> purchase (@RequestBody Seat seat) throws Exception {
        return new ResponseEntity<>(service.purchase(seat), HttpStatus.CREATED);
    }
}
