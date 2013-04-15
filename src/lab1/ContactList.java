package lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Mark
 */
public class ContactList {

    private Contact contact;
    
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
        ContactList c = new ContactList();
        c.getContacts();
    
    }
    
    public void getContacts() {
        File data = new File(File.separatorChar + "temp" + File.separatorChar
                + "data1.txt");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(data));
            String line = in.readLine();
            while (line != null) {
                String str[] = line.split("_");
                if (str.length >=8) {
                    setContact(str);
                    System.out.println(contact.toString());
                }
                else{
                    System.out.println("Input line did not have enough fields");
                }
                //outputRecord(str);
                line = in.readLine();  // strips out any carriage return chars
            }
        } catch (IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
    }
    
}
