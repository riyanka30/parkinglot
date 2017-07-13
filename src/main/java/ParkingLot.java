import java.util.*;

/**
 * Created by vidhyan on 13/07/17.
 */
public class ParkingLot {

    private final int parkingLotSize;
    private final Set<Car> slotList;
    private LotOwner owner;

    public ParkingLot(int parkingLotSize) {
        this.parkingLotSize = parkingLotSize;
        slotList = new HashSet<Car>();
    }

    public boolean park(Car car) {
        boolean parkedCar = assignSlot(car);
        informOwnerLotFullStatus(isFull());
        return parkedCar;
    }

    private void informOwnerLotFullStatus(boolean status) {
        if (owner != null) owner.setFullSign(status);
    }

    public boolean unpark(Car car) {
        boolean unparkedCar = slotList.remove(car);
        informOwnerLotFullStatus(isFull());
        return unparkedCar;
    }

    private boolean assignSlot(Car car) {
        if (isFull()) return false;
        return slotList.add(car);
    }

    public boolean isFull() {
        return slotList.size() == parkingLotSize;
    }

    public void addOwner(LotOwner owner) {
        this.owner = owner;
    }
}
