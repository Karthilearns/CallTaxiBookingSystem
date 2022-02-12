public class Taxi
{
    String taxiId;
    int drop_time;
    Character position;
    int earnings;

    @Override
    public String toString() {
        return "Taxi{" +
                "taxiId='" + taxiId + '\'' +
                ", drop_time=" + drop_time +
                ", position='" + position + '\'' +
                ", earnings=" + earnings +
                '}';
    }

    public Taxi(String taxiId, int drop_time, Character position, int earnings) {
        this.taxiId = taxiId;
        this.drop_time = drop_time;
        this.position = position;
        this.earnings = earnings;
    }

    public String getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(String taxiId) {
        this.taxiId = taxiId;
    }

    public int getDrop_time() {
        return drop_time;
    }

    public void setDrop_time(int drop_time) {
        this.drop_time = drop_time;
    }

    public Character getPosition() {
        return position;
    }

    public void setPosition(Character position) {
        this.position = position;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

}
