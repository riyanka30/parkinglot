import java.util.*;

/**
 * Created by vidhyan on 13/07/17.
 */
public class ParkingLot {

    private final int parkingLotSize;
    private final Set<Car> slotList;
    private final Set<ParkingLotObserver> parkingLotObservers;

    public ParkingLot(int parkingLotSize) {
        this.parkingLotSize = parkingLotSize;
        slotList = new HashSet<Car>();
        parkingLotObservers = new HashSet<ParkingLotObserver>();
    }

    public boolean park(Car car) {
        boolean parkedCar = assignSlot(car);
        informFullStatus(isFull());
        return parkedCar;
    }

    private void informFullStatus(boolean status) {
        Iterator<ParkingLotObserver> parkingLotObserverIterator = parkingLotObservers.iterator();
        while(parkingLotObserverIterator.hasNext()){
            parkingLotObserverIterator.next().informFullStatus(status);
        }
    }

    public boolean unpark(Car car) {
        boolean unparkedCar = slotList.remove(car);
        informFullStatus(isFull());
        return unparkedCar;
    }

    private boolean assignSlot(Car car) {
        if (isFull()) return false;
        return slotList.add(car);
    }

    public boolean isFull() {
        return slotList.size() == parkingLotSize;
    }

    public void addParkingLotObserver(ParkingLotObserver parkingLotObserver) {
        parkingLotObservers.add(parkingLotObserver);
    }

}
