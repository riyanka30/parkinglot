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
    public void OwnerShouldKnowParkingLotFull_When_Parked(){
        LotOwner owner = new LotOwner();
        ParkingLot lot = new ParkingLot(1);
        lot.addParkingLotObserver(owner);
        Car car = new Car();
        lot.park(car);
        Assert.assertTrue(owner.isFullSign());
    }

    @Test
    public void OwnerShouldKnowParkingLotNotFull_When_CarParked(){
        LotOwner owner = new LotOwner();
        ParkingLot lot = new ParkingLot(2);
        lot.addParkingLotObserver(owner);
        Car car = new Car();
        lot.park(car);
        lot.park(car);
        Assert.assertFalse(owner.isFullSign());
    }

    @Test
    public void OwnerShouldKnowParkingLotNotFull_When_carUnparked(){
        LotOwner owner = new LotOwner();
        ParkingLot lot = new ParkingLot(1);
        lot.addParkingLotObserver(owner);
        Car car = new Car();
        lot.park(car);
        Assert.assertTrue(owner.isFullSign());
        lot.unpark(car);
        Assert.assertFalse(owner.isFullSign());
    }

    @Test
    public void OwnerShouldKnowParkingLotNotFull_When_unparkingDifferentCar(){
        LotOwner owner = new LotOwner();
        ParkingLot lot = new ParkingLot(2);
        lot.addParkingLotObserver(owner);
        Car car1 = new Car();
        Car car2 = new Car();
        lot.park(car1);
        lot.unpark(car2);
        Assert.assertFalse(owner.isFullSign());
    }

    @Test
    public void SecurityShouldKnowParkingLotFull_When_Parked(){
        SecurityPersonnel personnel = new SecurityPersonnel();
        ParkingLot lot = new ParkingLot(1);
        lot.addParkingLotObserver(personnel);
        Car car = new Car();
        lot.park(car);
        Assert.assertTrue(personnel.isFullSign());
    }

    @Test
    public void SecurityShouldKnowParkingLotNotFull_When_CarParked(){
        SecurityPersonnel personnel = new SecurityPersonnel();
        ParkingLot lot = new ParkingLot(2);
        lot.addParkingLotObserver(personnel);
        Car car = new Car();
        lot.park(car);
        lot.park(car);
        Assert.assertFalse(personnel.isFullSign());
    }

}
