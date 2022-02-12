public class Booked
{
    private int bookingId;
    private int CustomerId;
    private char from;
    private char to;
    private int pickUpTime;
    private int dropTime;
    private int amount;

    public Booked(int bookingId, int customerId, char from, char to, int pickUpTime, int dropTime, int amount) {
        this.bookingId = bookingId;
        CustomerId = customerId;
        this.from = from;
        this.to = to;
        this.pickUpTime = pickUpTime;
        this.dropTime = dropTime;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Booked{" +
                "bookingId=" + bookingId +
                ", CustomerId=" + CustomerId +
                ", from=" + from +
                ", to=" + to +
                ", pickUpTime=" + pickUpTime +
                ", dropTime=" + dropTime +
                ", amount=" + amount +
                '}';
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public char getFrom() {
        return from;
    }

    public void setFrom(char from) {
        this.from = from;
    }

    public char getTo() {
        return to;
    }

    public void setTo(char to) {
        this.to = to;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(int pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
