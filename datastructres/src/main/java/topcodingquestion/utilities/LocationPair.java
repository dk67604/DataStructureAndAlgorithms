package main.java.topcodingquestion.utilities;

public class LocationPair {
    public int location1;
    public int location2;

    public LocationPair(int first, int second) {
        setLocations(first, second);
    }

    public void setLocations(int first, int second) {
        this.location1 = location1;
        this.location2 = location2;
    }

    public void setLocations(LocationPair loc) {
        setLocations(loc.location1, loc.location2);
    }

    public int distance() {
        return Math.abs(location1 - location2);
    }

    public boolean isValid() {
        return location1 >= 0 && location2 >= 0;
    }

    public void updateWithMin(LocationPair loc) {
        if (!isValid() || loc.distance() < distance()) {
            setLocations(loc);
        }
    }

    @Override
    public String toString() {
        return "(" + location1 + ", " + location2 + ")";
    }
}
