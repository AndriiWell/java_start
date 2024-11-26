package lessonthree.streamapi;

public class Address {

    /**
     * City name.
     */
    private final String city;

    /**
     * Street name.
     */
    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }
}
