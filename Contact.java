import javax.swing.plaf.PanelUI;
import java.util.ArrayList;

public class Contact {

    private String firstName;
    private String lastName;
    private ArrayList<PhoneNumber> numList;
    private String newFirstName ;
    private String newLastName;


    public Contact(String newFirstName, String newLastName) {
        this.newFirstName = newFirstName;
        this.newLastName = newLastName;
    }

    public Contact(String firstName, String lastName, ArrayList<PhoneNumber> numList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numList = numList;
    }


    public Contact() {}


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

    public ArrayList<PhoneNumber> getNumList() {
        return numList;
    }

    public void setNumList(ArrayList<PhoneNumber> numList) {
        this.numList = numList;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public void setNewFirstName(String newFirstName) {
        this.newFirstName = newFirstName;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public void setNewLastName(String newLastName) {
        this.newLastName = newLastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + numList.toString();
    }

}
