package inheritance;

public class Address {
    private String area;
    private String city;
    private String state;
    private int pincode;

    public Address(String area, String city, String state, int pincode) {
        this.area = area;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getPincode() {
        return pincode;
    }

    @Override
    public String toString() {
        return "Address [area=" + area + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
    }
}
