package christmas.domain.reservation.model;

import christmas.domain.payment.model.Receipt;
import java.util.HashMap;
import java.util.Map;

public class ReservationRepository {

    private static final Map<Reservation, Receipt> reservationRepo = new HashMap<>();

    public void addReservation(Reservation reservation, Receipt receipt) {
        reservationRepo.put(reservation, receipt);
    }
}
