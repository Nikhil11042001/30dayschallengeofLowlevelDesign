package models;

public class Customer {

    private final String name;
    private final String contactNo;
    private final String driverLicense;


    public Customer(String name, String contactNo, String driverLicense) {
        this.name = name;
        this.contactNo = contactNo;
        this.driverLicense = driverLicense;
    }

    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getDriverLicense() {
        return driverLicense;
    }
}
