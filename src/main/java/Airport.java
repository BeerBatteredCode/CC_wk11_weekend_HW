import java.util.ArrayList;

public class Airport {

    public String airportcode;
    public ArrayList<Plane> hanger;
    public ArrayList<Plane> outbound;
    public ArrayList<Flight> newFlight;
    public int totalRevenue;

    public Airport(String airportcode, int totalRevenue){
        this.airportcode = airportcode;
        this.hanger = new ArrayList<>();
        this.outbound = new ArrayList<>();
        this.newFlight = new ArrayList<>();
        this.totalRevenue = totalRevenue;
    }

//BASIC FUNCTIONS

    public int getRevenueTotal() {
        return totalRevenue;
    }

    public String getAirportCode() {
        return airportcode;
    }

//    HANGER FUNCTIONS

    public int getHangerRoster() {
        return hanger.size();
    }

    public void addPlaneToHanger(Plane plane) {
        hanger.add(plane);
    }

    public void removePlaneFromHanger() {
        hanger.remove(0);
    }

    public String getPlaneFromHangerByCallsign(Plane named) {
        for (int i = 0; i < hanger.size(); i++) {
            if (hanger.get(i).getCallsign() == named.getCallsign()){
                return named.callsign;
            }
        }
        return null;
    }


    public void removeFromHangerByCallsign(Plane plane) {
        for (int i = 0; i < hanger.size(); i++) {
            if (hanger.get(i).getCallsign() == plane.getCallsign()){
                hanger.remove(i);
            }
        }
    }

    public ArrayList<Integer> organiseArray() {
        ArrayList<Integer> hangerNumbers = new ArrayList<>();

        for (int i = 0; i < hanger.size(); i++) {
            int capacity = hanger.get(i).getCapacity();
            hangerNumbers.add(capacity);
        }
        return hangerNumbers;
    }



//    OUTBOUND FUNCTIONS

    public int getOutboundRoster() {
        return outbound.size();
    }


    public void addPlaneToOutbound(Plane plane1) {
        outbound.add(plane1);
    }

    public void removePlaneFromOutbound() {
        outbound.remove(0);
    }

    public void moveFromHangerToOutbound(Plane outgoing) {
        for (int i = 0; i < hanger.size(); i++) {
            if (hanger.get(i).getCallsign() == outgoing.getCallsign()){
                removeFromHangerByCallsign(outgoing);
                outbound.add(outgoing);
            }
        }
    }

//    NEW FLIGHT FUNCTIONS


    public int getNewFlightRoster() {
        return newFlight.size();
    }

    public void createNewFlight(Flight flight) {
        newFlight.add(flight);
    }

    public void removeNewFlight() {
        newFlight.remove(0);
    }

    public String getNewFlightByCallsign(Flight assigned) {
        for (int i = 0; i < newFlight.size(); i++) {
            if (newFlight.get(i).getCallsign() == assigned.getCallsign()){
                return assigned.callsign;
            }
        }
        return null;
    }

    public void removeNewFlightByCallsign(Flight assigned) {
        for (int i = 0; i < newFlight.size(); i++) {
            if (newFlight.get(i).getCallsign() == assigned.getCallsign()){
                newFlight.remove(i);
            }
        }
    }

    public void moveFromHangerToAssignedFlight(Plane assigned, Flight scheduled) {
        for (int i = 0; i < hanger.size(); i++) {
            if (hanger.get(i).getCallsign() == assigned.getCallsign()){
                removeFromHangerByCallsign(assigned);
                scheduled.assignPlaneToFlight(assigned);
            }
        }
    }


    public void moveFromHangerToAdaptedFlight(Flight scheduled) {
        for (int i = 0; i < hanger.size(); i++) {
            if (hanger.get(i).getCapacity() < scheduled.getMinimum()){
                removeFromHangerByCallsign(hanger.get(i));
                scheduled.assignPlaneToFlight(hanger.get(i));
            }
        }
    }

    public void sellTicketToPassenger(Passenger passenger, Flight ticket) {
        if (passenger.wallet >= ticket.cost) {
            passenger.wallet -= ticket.cost;
            totalRevenue += ticket.cost;
        } else {
            System.out.println("Insufficient funds");
        }
    }

//    SELLING TICKET FUNCTIONS

    public void bookPassengerIn(Passenger passenger, Plane plane, Flight flight) {
        if (flight.getBookingTotal() < flight.getCapacity(plane)){
            flight.addPassengerToBooking(passenger);
        } else {
            System.out.println("Ticket unavailable");
        }
    }
}

