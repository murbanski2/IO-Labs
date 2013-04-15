package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Mark Urbanski
 */
public class ContactList2 {
    private Contact contact;
    private static final String BLANK_LINES = "\n\n";
    private static final String INPUT_FIELDS_ERROR 
            = "Input line did not have enough fields";
    private static final String LINE_NOT_FOUND
            = "Input line not found";
    private static final String IO_EXCEPTION
            = "Houston, we have a problem! reading this file";

    
    public Contact getContact() {
        return contact;
    }

    public void setContact(String s[]) {
        this.contact = new Contact();
        contact.setFirstName(s[0]);
        contact.setLastName(s[1]);
        contact.setAddress(s[2]);
        contact.setCity(s[3]);
        contact.setState(s[4]);
        contact.setZip(s[5]);
        contact.setEmail(s[6]);
        contact.setPhone(s[7]);
        
    }


    public static void main(String[] args) {
        ContactList2 c = new ContactList2();
        c.getContacts(0, ContactFields.ALL);
        System.out.println(BLANK_LINES);
        c.getContacts(2, ContactFields.CITY);
        c.getContacts(4, ContactFields.ALL);
    
    }
    
    /**
     * getContacts(int lineNumber, ContactFields cf)
     * @param lineNumber
     * @param cf 
     * lineNumber is the line you want, starting at 1 for the first line.
     * lineNumber = 0 if you want all lines.
     * ContactFields is from the enumeration ContactFields.  ALL for all, 
     * otherwise select the field desired.
     */
    public void getContacts(int lineNumber, ContactFields cf) {
        File data = new File(File.separatorChar + "temp" + File.separatorChar
                + "data1.txt");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(data));
            String line = in.readLine();
            int currentLine = 0;
            while (line != null) {
                currentLine ++;
                String str[] = line.split("_");
                if (str.length >=8) {
                    setContact(str);
                    if (lineNumber == 0 || lineNumber == currentLine){
                        System.out.println(getFieldOutput(cf));
                    }
                }
                else{
                    System.out.println(INPUT_FIELDS_ERROR);
                }
                //outputRecord(str);
                line = in.readLine();  // strips out any carriage return chars
            }
            if (lineNumber > currentLine) {
                System.out.println(LINE_NOT_FOUND);
            }
        } catch (IOException ioe) {
            System.out.println(IO_EXCEPTION);
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
    }
    
    public String getFieldOutput(ContactFields cf) {
        String result;
        switch (cf) {
            case ALL:
                result = contact.toString(); 
                break;
            case FIRST:
                result = "First Name: " + contact.getFirstName();
                break;
            case LAST:
                result = "Last Name: " + contact.getLastName();
                break;
            case ADDRESS:
                result = "Address: " + contact.getAddress();
                break;
            case CITY:
                result = "City: " + contact.getCity();
                break;
            case STATE:
                result = "State: " + contact.getState();
                break;
            case ZIP:
                result = "Zip: " + contact.getZip();
                break;
            case EMAIL:
                result = "Email: " + contact.getEmail();
                break;
            case PHONE:
                result = "Phone: " + contact.getPhone();
                break;
            default:
                result = "Field not found";
                break;
        }

        return result;
    }
    
}
