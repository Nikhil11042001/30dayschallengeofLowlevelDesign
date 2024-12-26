package models;

public class Car {

    private final String make;
    private final int Year;
    private final String plateNumber;
    private final double rentalPricePerDay;
    private boolean isAvailable;

    public Car(String make, int year, String plateNumber, double rentalPricePerDay) {
        this.make = make;
        Year = year;
        this.plateNumber = plateNumber;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isAvailable=true;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return Year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
