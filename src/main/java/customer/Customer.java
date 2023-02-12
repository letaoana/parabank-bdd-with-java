package customer;

import com.github.javafaker.Faker;

public class Customer {
    private Faker faker;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String ssn;

    public Customer(Faker faker){
        this.faker = faker;
        setFirstName();
        setLastName();
        setSsn();
        setUsername();
        setPassword();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName() {
        this.firstName = faker.name().firstName();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName() {
        this.lastName = faker.name().lastName();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        this.username = faker.name().username();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = faker.internet().password();
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn() {
        this.ssn = faker.idNumber().ssnValid();
    }

}
