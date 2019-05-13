import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    Passenger passenger1;
    Passenger passenger2;

    @Before
    public void before(){
        plane = new Plane("EJ428", Airline.EASYJET, Type.BOEING_777);
        passenger1 = new Passenger("Lenny Kravits", 300);
        passenger2 = new Passenger("Dave Grohl", 700);
    }


    @Test
    public void checkCanGetCallsign(){
        assertEquals("EJ428", plane.getCallsign());
    }

    @Test
    public void checkCanGetAirline(){
        assertEquals(Airline.EASYJET, plane.getAirline());
    }

    @Test
    public void checkCanGetType(){
        assertEquals(Type.BOEING_777, plane.getType());
    }

    @Test
    public void checkCanGetCapacity(){
        assertEquals(700, plane.getCapacity());
    }

    @Test
    public void checkCanGetFullManifest(){
        plane.addPassenger(passenger1);
        plane.addPassenger(passenger2);
        assertEquals(2, plane.getManifest());
    }

    @Test
    public void checkCanAddPassenger(){
        plane.addPassenger(passenger1);
        assertEquals(1, plane.getManifest());
    }

    @Test
    public void checkCanRemovePassengerByName(){
        plane.addPassenger(passenger1);
        plane.addPassenger(passenger2);
        plane.removePassengerByName(passenger2);
        assertEquals("Lenny Kravits", plane.getPassengerName(passenger1));
    }

    @Test
    public void checkCanClearPlaneManifest(){
        plane.addPassenger(passenger1);
        plane.addPassenger(passenger2);
        plane.clearPassengers();
        assertEquals(0, plane.getManifest());
    }
}
