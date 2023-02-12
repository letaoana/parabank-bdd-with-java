package customer;

import com.github.javafaker.Faker;

public class CustomerAddress {
    private Faker faker;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    public CustomerAddress(Faker faker){
        this.faker = faker;
        setAddress();
        setCity();
        setState();
        setZipCode();
    }

    public String getAddress() {
        return address;
    }

    private void setAddress() {
        this.address = faker.address().streetAddress();
    }

    public String getCity() {
        return city;
    }

    private void setCity() {
        this.city = faker.address().cityName();
    }

    public String getState() {
        return state;
    }

    private void setState() {
        this.state = faker.address().state();
    }

    public String getZipCode() {
        return zipCode;
    }

    private void setZipCode() {
        this.zipCode = faker.address().zipCode();
    }
}
