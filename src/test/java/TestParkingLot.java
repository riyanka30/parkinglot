import org.junit.Assert;
import org.junit.Test;


/**
 * Created by vidhyan on 13/07/17.
 */
public class TestParkingLot {

    @Test
    public void test_ParkCar(){
        ParkingLot lot = new ParkingLot(2);
        Car car = new Car();
        Assert.assertTrue(lot.park(car));
    }

    @Test
    public void test_DoNotParkCar_WhenLotIsFull(){
        ParkingLot lot = new ParkingLot(2);
        Car car = new Car();
        Assert.assertTrue(lot.park(car));
        Car car2 = new Car();
        Assert.assertTrue(lot.park(car2));
        Car car3 = new Car();
        Assert.assertFalse(lot.park(car3));
    }

    @Test
    public void test_ParkAParkedCar(){
        ParkingLot lot = new ParkingLot(2);
        Car car = new Car();
        lot.park(car);
        Assert.assertFalse(lot.park(car));

    }

    @Test
    public void test_UnparkCar(){
        ParkingLot lot = new ParkingLot(5);
        Car car = new Car();
        lot.park(car);
        Assert.assertTrue(lot.unpark(car));
    }

    @Test
    public void test_UnparkAUnparkedCar(){
        ParkingLot lot = new ParkingLot(5);
        Car car = new Car();
        Assert.assertTrue(lot.park(car));
        Assert.assertTrue(lot.unpark(car));
        Assert.assertFalse(lot.unpark(car));
    }

    @Test
    public void test_IsParkingLotFull(){
        ParkingLot lot = new ParkingLot(2);
        Car car1 = new Car();
        lot.park(car1);
        Car car2 = new Car();
        lot.park(car2);
        boolean isFull=lot.isFull();
        Assert.assertTrue(isFull);
    }

    @Test
    public void test_IsParkingAvailable(){
        ParkingLot lot = new ParkingLot(2);
        Car car1 = new Car();
        lot.park(car1);
        boolean isFull=lot.isFull();
        Assert.assertFalse(isFull);
    }

    @Test
    public void OwnerShouldKnowParkingLotFull(){
        LotOwner owner = new LotOwner();
        ParkingLot lot = new ParkingLot(1);
        lot.addOwner(owner);
        Car car = new Car();
        lot.park(car);
        Assert.assertTrue(owner.fullSign);
    }

    @Test
    public void OwnerShouldKnowParkingLotNotFull(){
        LotOwner owner = new LotOwner();
        ParkingLot lot = new ParkingLot(2);
        lot.addOwner(owner);
        Car car = new Car();
        lot.park(car);
        lot.park(car);
        Assert.assertFalse(owner.fullSign);
    }

}
