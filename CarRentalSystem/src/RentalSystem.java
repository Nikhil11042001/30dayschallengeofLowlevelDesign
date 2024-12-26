import models.Car;
import models.Customer;
import models.Reservation;
import payment.CreditCardPaymentProcessor;
import payment.PaymentProcessor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class RentalSystem {

    private static RentalSystem rentalSystem;
    private final Map<String, Car> cars;

    private final Map<String, Reservation> reservations;

    private final PaymentProcessor paymentProcessor;

    private RentalSystem (){
        this.cars = new ConcurrentHashMap<>();
        this.reservations = new ConcurrentHashMap<>();
        paymentProcessor = new CreditCardPaymentProcessor();
    };

    public static synchronized RentalSystem getInstance(){
        if(rentalSystem==null){
            rentalSystem=new RentalSystem();
        }
        return rentalSystem;
    }

    public void addCar(Car car){
        cars.put(car.getPlateNumber(),car);
    }

    public void removeCar(String licensePlate) {
        cars.remove(licensePlate);
    }

    public synchronized Reservation makeReservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        if (isCarAvailable(car, startDate, endDate)) {
            String reservationId = generateReservationId();
            Reservation reservation = new Reservation(reservationId, customer, car, startDate, endDate);
            reservations.put(reservationId, reservation);
            car.setAvailable(false);
            return reservation;
        }
        return null;
    }


    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        for (Reservation reservation : reservations.values()) {
            if (reservation.getCar().equals(car)) {
                if (startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate) {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars.values()) {
            if (car.getMake().equalsIgnoreCase(make) && car.isAvailable()) {
                if (isCarAvailable(car, startDate, endDate)) {
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }



    private String generateReservationId() {
        return "RES"+ UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }

    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = reservations.remove(reservationId);
        if (reservation != null) {
            reservation.getCar().setAvailable(true);
        }
    }


}
