package cinema.service;

import cinema.model.Cinema;
import cinema.model.Seat;

public interface Service {
    Cinema getAllSeat();
    Seat purchase(Seat seat) throws Exception;
}
