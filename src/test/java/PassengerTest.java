import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Lenny Kravits", 300);
    }

    @Test
    public void checkCanGetName(){
        assertEquals("Lenny Kravits", passenger.getName());
    }

    @Test
    public void checkCanGetWallet(){
        assertEquals(300, passenger.getWallet());
    }

}
