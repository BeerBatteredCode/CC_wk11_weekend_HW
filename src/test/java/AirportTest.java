import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport;

    Passenger passenger1;
    Passenger passenger2;

    Plane plane1;
    Plane plane2;
    Plane plane3;
    Plane plane4;
    Plane plane5;
    Plane plane6;

    Flight flight1;
    Flight flight2;
    Flight flight3;

    @Before
    public void before(){
        airport = new Airport("EDB", 10000);

        passenger1 = new Passenger("Lenny Kravits", 300);
        passenger2 = new Passenger("Dave Grohl", 700);

        plane1 = new Plane("EJ428", Airline.EASYJET, Type.BOEING_777);
        plane2 = new Plane("RA223", Airline.RYANAIR, Type.AIRBUS_A340);
        plane3 = new Plane("JT432", Airline.JET2, Type.BOEING_666);
        plane4 = new Plane("FB878", Airline.FLYBE, Type.BOEING_888);
        plane5 = new Plane("RA121", Airline.RYANAIR, Type.AIRBUS_A333);
        plane6 = new Plane("JT541", Airline.JET2, Type.AIRBUS_A350);

        flight1 = new Flight("EJ428", 2440, Destination.LDN, 250);
        flight2 = new Flight("RA223", 2560, Destination.PRS, 350);
        flight3 = new Flight("RA223", 3221, Destination.TKO, 350);
    }



//BASIC TESTS

    @Test
    public void checkGetRevenueTotal(){
        assertEquals(10000, airport.getRevenueTotal());
    }

    @Test
    public void checkGetAirportCode(){
        assertEquals("EDB", airport.getAirportCode());
    }



//    HANGER TESTS

    @Test
    public void checkHangerRosterCount(){
        assertEquals(0, airport.getHangerRoster());
    }

    @Test
    public void checkAddPlaneToHanger(){
        airport.addPlaneToHanger(plane1);
        airport.addPlaneToHanger(plane2);
        assertEquals(2, airport.getHangerRoster());
    }

    @Test
    public void checkRemovePlaneFromHanger(){
        airport.addPlaneToHanger(plane1);
        airport.addPlaneToHanger(plane2);
        airport.removePlaneFromHanger();
        assertEquals(1, airport.getHangerRoster());
    }

    @Test
    public void checkGetPlaneFromHangerByCallsign(){
        airport.addPlaneToHanger(plane1);
        airport.addPlaneToHanger(plane2);
        assertEquals("RA223", airport.getPlaneFromHangerByCallsign(plane2));
    }

    @Test
    public void checkRemoveFromHangerByCallsign(){
        airport.addPlaneToHanger(plane1);
        airport.addPlaneToHanger(plane2);
        airport.removeFromHangerByCallsign(plane2);
        assertEquals(null, airport.getPlaneFromHangerByCallsign(plane2));
    }




//    OUTBOUND TESTS

    @Test
    public void checkOutboundRosterCount(){
        assertEquals(0, airport.getOutboundRoster());
    }

    @Test
    public void checkCanAddPlaneToOutbound(){
        airport.addPlaneToOutbound(plane1);
        airport.addPlaneToOutbound(plane2);
        assertEquals(2, airport.getOutboundRoster());
    }

    @Test
    public void checkCanRemovePlaneFromOutbound(){
        airport.addPlaneToOutbound(plane1);
        airport.addPlaneToOutbound(plane2);
        airport.removePlaneFromOutbound();
        assertEquals(1, airport.getOutboundRoster());
    }

    @Test
    public void checkCanMoveFromHangerToOutbound(){
        airport.addPlaneToHanger(plane1);
        airport.addPlaneToHanger(plane2);
        airport.moveFromHangerToOutbound(plane1);
        assertEquals(1, airport.getHangerRoster());
        assertEquals(1, airport.getOutboundRoster());
    }




//    NEW FLIGHT TESTS

    @Test
    public void checkCanGetNewFlightRoster(){
        assertEquals(0, airport.getNewFlightRoster());
    }

    @Test
    public void checkCanCreateNewFlight(){
        airport.createNewFlight(flight1);
        assertEquals(1, airport.getNewFlightRoster());
    }

    @Test
    public void checkCanRemoveNewFlight(){
        airport.createNewFlight(flight1);
        airport.createNewFlight(flight2);
        airport.removeNewFlight();
        assertEquals(1, airport.getNewFlightRoster());
    }

    @Test
    public void checkCanGetNewFlightCallsign(){
        airport.createNewFlight(flight1);
        assertEquals("EJ428", airport.getNewFlightByCallsign(flight1));
    }

    @Test
    public void checkCanRemoveNewFlightByCallsign(){
        airport.createNewFlight(flight1);
        airport.createNewFlight(flight2);
        airport.removeNewFlightByCallsign(flight2);
        assertEquals(null, airport.getNewFlightByCallsign(flight2));
    }

    @Test
    public void checkCanAssignPlaneToFlight(){
        flight1.assignPlaneToFlight(plane1);
        assertEquals("EJ428", flight1.getAssignedPlaneByCallsign(plane1));
    }

    @Test
    public void checkCanAssignPlaneFromHanger(){
        airport.addPlaneToHanger(plane1);
        airport.addPlaneToHanger(plane2);
        airport.moveFromHangerToAssignedFlight(plane2, flight1);
        assertEquals(1, airport.getHangerRoster());
        assertEquals(1, flight1.getAssignedPlaneTotal());
    }




//    SELLING TICKETS TESTS

    @Test
    public void checkCanSellTicketToPassenger(){
        airport.sellTicketToPassenger(passenger1, flight1);
        assertEquals(10250, airport.getRevenueTotal());
    }

    @Test
    public void checkCanBookPassengerIn(){
        airport.bookPassengerIn(passenger1, plane1, flight1);
        assertEquals(1, flight1.getBookingTotal());
    }

    @Test
    public void checkFailToBookPassengerIn(){
        airport.bookPassengerIn(passenger1, plane3, flight1);
        airport.bookPassengerIn(passenger1, plane3, flight1);
        airport.bookPassengerIn(passenger1, plane3, flight1);
        airport.bookPassengerIn(passenger1, plane3, flight1);
        airport.bookPassengerIn(passenger1, plane3, flight1);
        airport.bookPassengerIn(passenger1, plane3, flight1);
        assertEquals(5, flight1.getBookingTotal());
    }

//    @Test
//    public void checkTotalTicketsSold(){
//        airport.bookPassengerIn(passenger1, plane1, flight1);
//        airport.bookPassengerIn(passenger1, plane1, flight1);
//        airport.bookPassengerIn(passenger1, plane1, flight1);
//        airport.bookPassengerIn(passenger1, plane2, flight2);
//        airport.bookPassengerIn(passenger1, plane2, flight2);
//        airport.bookPassengerIn(passenger1, plane2, flight2);
//        airport.bookPassengerIn(passenger1, plane3, flight3);
//        airport.bookPassengerIn(passenger1, plane3, flight3);
//        airport.bookPassengerIn(passenger1, plane3, flight3);
//        assertEquals(9, airport.totalBookedFlights(flight1, flight2, flight3));
//    }

//    ASSIGN PLANE TO FLIGHT TEST

//    @Test
//    public void checkCanAssignPlaneViaSize(){
//        airport.addPlaneToHanger(plane1);
//        airport.addPlaneToHanger(plane2);
//        airport.addPlaneToHanger(plane3);
//        airport.addPlaneToHanger(plane4);
//        airport.addPlaneToHanger(plane5);
//        airport.addPlaneToHanger(plane6);
//        airport.moveFromHangerToAdaptedFlight(flight1);
//        assertEquals("RA121", flight1.getCallsign());
//    }
//
//    @Test
//    public void checkCanOrganiseArray(){
//        airport.addPlaneToHanger(plane1);
//        airport.addPlaneToHanger(plane2);
//        airport.addPlaneToHanger(plane3);
//        airport.addPlaneToHanger(plane4);
//        airport.addPlaneToHanger(plane5);
//        airport.addPlaneToHanger(plane6);
//        airport.organiseArray();
//        assertEquals("JT432", airport.hanger.get(0).getCallsign());
//    }

}
