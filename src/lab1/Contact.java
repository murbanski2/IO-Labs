package lab1;

/**
 *
 * @author Mark Urbanski
 */
public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String phone;
    private static final String TOSTRING_FORMATTED_LINE = 
            "First Name: %s   Last Name %s   Address: %s   City: %s   " +
            "State: %s   Zip: %s   Email: %s   Phone: %s   ";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        String formattedString = String.format(TOSTRING_FORMATTED_LINE, 
                firstName, lastName, address, city, state, zip, email, phone);
        return formattedString;
    }
           

}
