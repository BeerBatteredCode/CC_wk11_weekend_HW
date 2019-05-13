import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;

public class Flight {

    public String callsign;
    public int flight_no;
    public Destination destination;
    public ArrayList<Plane> assignedPlane;
    public ArrayList<Passenger> bookedIn;
    public int cost;
    public int capacity;
    public int minimum;


    public Flight(String callsign, int flight_no, Destination destination, int cost){
        this.callsign = callsign;
        this.flight_no = flight_no;
        this.destination = destination;
        this.assignedPlane = new ArrayList<>();
        this.bookedIn = new ArrayList<>();
        this.cost = cost;
        this.capacity = capacity;
        this.minimum = minimum;
    }

//    BASIC FUNCTIONS

    public String getCallsign() {
        return callsign;
    }

    public int getFlightNo() {
        return flight_no;
    }

    public int getAssignedPlaneTotal() {
        return assignedPlane.size();
    }

    public int getBookingTotal() {
        return bookedIn.size();
    }

    public int getCapacity(Plane plane){
        capacity = plane.type.getPlaneCapacity();
        return capacity;
    }

    public int getMinimum(){
        minimum = destination.getMinimumBooking();
        return minimum;
    }

//    PLANE ASSIGNMENT FUNCTIONS

    public void assignPlaneToFlight(Plane plane) {
        if (assignedPlane.size() < 1){
            assignedPlane.add(plane);
        }
    }

    public void removePlaneFromFlight() {
        assignedPlane.remove(0);
    }

    public String getAssignedPlaneByCallsign(Plane plane) {
        for (int i = 0; i < assignedPlane.size(); i++) {
            return plane.callsign;
        }
        return null;
    }


//    PASSENGER ASSIGNMENT FUNCTIONS

//    public void bookPassengerIn(Passenger passenger, Plane plane) {
//        if (this.getCapacity(plane) < this.getBookingTotal()){
//            addPassengerToBooking(passenger);
//        }
//    }

    public void addPassengerToBooking(Passenger passenger) {
        bookedIn.add(passenger);
    }
}
