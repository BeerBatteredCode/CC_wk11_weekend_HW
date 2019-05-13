import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;

    Passenger passenger1;
    Passenger passenger2;

    Plane plane1;
    Plane plane2;

    @Before
    public void before(){
        flight = new Flight("EJ428", 2440, Destination.GLA , 250);

        passenger1 = new Passenger("Lenny Kravits", 300);
        passenger2 = new Passenger("Dave Grohl", 700);

        plane1 = new Plane("EJ428", Airline.EASYJET, Type.BOEING_777);
        plane2 = new Plane("RA223", Airline.RYANAIR, Type.AIRBUS_A340);
    }

//    BASIC FUNCTION TESTS

    @Test
    public void checkGetCallsign(){
        assertEquals("EJ428", flight.getCallsign());
    }

    @Test
    public void checkGetFlightNumber(){
        assertEquals(2440, flight.getFlightNo());
    }

    @Test
    public void checkGetCapacity(){
        assertEquals(700, flight.getCapacity(plane1));
    }

    @Test
    public void checkGetBookingTotal(){
        assertEquals(0, flight.getBookingTotal());
    }

    @Test
    public void checkGetMinimumBooking(){
        assertEquals(5, flight.getMinimum());
    }

//    BOOKING TESTS


//    PLANE ASSIGNMENT TESTS

    @Test
    public void checkAssignedPlaneAdded(){
        assertEquals(0, flight.getAssignedPlaneTotal());
    }

    @Test
    public void checkCanAddPlaneToAssignedPlane(){
        flight.assignPlaneToFlight(plane1);
        assertEquals(1, flight.getAssignedPlaneTotal());
    }

    @Test
    public void checkCanRemovePlaneFromAssigned(){
        flight.assignPlaneToFlight(plane1);
        flight.removePlaneFromFlight();
        assertEquals(0, flight.getAssignedPlaneTotal());
    }

    @Test
    public void checkMaxPlaneCanBeAssigned(){
        flight.assignPlaneToFlight(plane1);
        flight.assignPlaneToFlight(plane2);
        assertEquals(1, flight.getAssignedPlaneTotal());
    }

    @Test
    public void checkCanGetAssignedFlight(){
        flight.assignPlaneToFlight(plane1);
        assertEquals("EJ428", flight.getAssignedPlaneByCallsign(plane1));
    }

//    PASSENGER ASSIGNMENT TEST

    @Test
    public void checkAddPassengerToBooking(){
        flight.addPassengerToBooking(passenger1);
        assertEquals(1, flight.getBookingTotal() );
    }
}
