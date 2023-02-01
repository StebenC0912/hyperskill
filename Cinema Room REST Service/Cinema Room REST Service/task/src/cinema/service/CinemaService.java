package cinema.service;

import cinema.model.Seat;
import cinema.model.inputSeat;
import cinema.model.responseCinema;

public interface CinemaService {
    responseCinema getAllSeat();
    Seat purchase(inputSeat seat) throws Exception;
}
