import java.util.ArrayList;

public class Plane {

    public String callsign;
    public Airline airline;
    public Type type;
    public ArrayList<Passenger> manifest;
    public int capacity;

    public Plane(String callsign, Airline airline, Type type) {
        this.callsign = callsign;
        this.airline = airline;
        this.type = type;
        this.manifest = new ArrayList<>();
        this.capacity = capacity;
    }

    public String getCallsign() {
        return callsign;
    }

    public Airline getAirline() {
        return airline;
    }

    public Type getType() {
        return type;
    }

    public int getManifest() {
        return manifest.size();
    }

    public int getCapacity(){
       capacity = type.getPlaneCapacity();
       return capacity;
    }

    public void addPassenger(Passenger passenger1) {
        manifest.add(passenger1);
    }

    public void removePassengerByName(Passenger unwanted) {
        for (int i = 0; i < manifest.size(); i++) {
            if (manifest.get(i).getName() == unwanted.getName()){
                manifest.remove(i);
            }
        }
    }

    public void clearPassengers() {
        manifest.clear();
    }

    public String getPassengerName(Passenger named) {
        for (int i = 0; i < manifest.size(); i++) {
            if (manifest.get(i).getName() == named.getName()){
                return named.name;
            }
        }
        return null;
    }
}
