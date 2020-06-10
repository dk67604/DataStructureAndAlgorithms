package main.java.systemdesign.parkinglot;

public class ParkingSpot {
    private String number;
    private boolean free;
    private Vehicle vehicle;
    private ParkingSpotType type;

    public ParkingSpotType getType() {
        return type;
    }

    public boolean isFree(){return true;}

    public ParkingSpot(ParkingSpotType type){
        this.type =type;
    }
    public boolean assignVehicle(Vehicle vehicle){
        this.vehicle =vehicle;
        free = false;
        return free;
    }
    public boolean removeVehicle(){
        this.vehicle =null;
        free = true;
        return free;
    }

    public String getNumber() {
        return number;
    }
}
