package lab;

public class Address {
    String country;
    String city;
    String street;
    int house;
    int flat;

    public Address(String country, String city, String street, int house, int flat) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    String addressToString(){
        return  "\nAddress" + "\n" +
                "Country: " + country + "\n" +
                "City: " + city + "\n" +
                "Street: " + street + " " + house + " " + flat + "\n";
    }
}
