public class Booking
{
    int customerId;
    Character pickupPoint;
    Character dropPoint;
    int pickUpTime;

    public Booking(int customerId, Character pickupPoint, Character dropPoint, int pickUpTime) {
        this.customerId = customerId;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickUpTime = pickUpTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Character getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(Character pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public Character getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(Character dropPoint) {
        this.dropPoint = dropPoint;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(int pickUpTime) {
        this.pickUpTime = pickUpTime;
    }
}
