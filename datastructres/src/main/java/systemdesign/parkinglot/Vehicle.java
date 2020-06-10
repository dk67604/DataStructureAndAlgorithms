package main.java.systemdesign.parkinglot;

public class Vehicle {
    private String licenseNumber;
    private VehicleType type;
    private ParkingTicket ticket;

    public Vehicle(VehicleType vehicleType){
        this.type = vehicleType;
    }
    public void assignTicket(ParkingTicket ticket){
        this.ticket = ticket;
    }

}
