/**
 * Created by riyankad on 7/13/17.
 */
public class LotOwner implements ParkingLotObserver{

    private boolean fullSign;

    public boolean isFullSign() {
        return fullSign;
    }

    public void informFullStatus(boolean fullSign) {
        this.fullSign = fullSign;
    }
}
