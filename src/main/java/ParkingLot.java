import java.security.acl.Owner;
import java.util.*;

/**
 * Created by vidhyan on 13/07/17.
 */
public class ParkingLot {

    private final int parkingLotSize;
    private final Set< Car> slotList;
    private LotOwner owner;

    public ParkingLot(int parkingLotSize) {
        this.parkingLotSize = parkingLotSize;
        slotList = new HashSet<Car>();
    }

    public boolean park( Car car){
        boolean parkedCar=assignSlot(car);
        if(isFull()) owner.setFullSign(true);
        return parkedCar;
    }

    public boolean unpark(Car car) {
        return slotList.remove(car);
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
