import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class PhoneBook {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Contact> contactList = new ArrayList<>();

    public int menu() throws Exception {
        System.out.println("***** ***** ***** ***** ***** ***** *****");
        System.out.println("Select one of these items:");
        System.out.println("1:AddContact \t" + "2:EditContact\t" + "3:DeleteContact\t" + "4:searchContact\t" +"5:ShowAll\t" + "0:Exit");
        System.out.println("***** ***** ***** ***** ***** ***** *****");
        int num = Integer.parseInt(input.nextLine()) ;
        switch (num){
            case 1:
                addContact();
                break;
            case 2:
                editContact();
                break;
            case 3:
                deleteContact();
                break;
            case 4:
                search();
                break;
            case 5:
                showAll();
                break;
            case 0 :
                break;
            default:
                throw new Exception("input number is not valid.try again please.");
        }
        return menu();
    }

    private void showAll() {
        contactList.forEach(System.out::println);
    }

    private void editContact() throws Exception {
//        Optional<Contact> findContact = findContact();
//        findContact.ifPresent();
//        if (!findContact.isPresent()) {
//            System.out.println("contact not find");
//        }

    }

    private void deleteContact() {
        Optional<Contact> findContact = findContact();
        findContact.ifPresent(contact -> {
            contactList.remove(contact);
            System.out.println("contact removed");
        });
        if (!findContact.isPresent())
            System.out.println("contact not find.");
    }

    private void search() {
        Optional<Contact> findContact = findContact();
        findContact.ifPresent(System.out::println);
        if (!findContact.isPresent())
            System.out.println("contact not find.");
    }

    private Optional<Contact> findContact() {
        String firstName = readLine("Enter your firstName :");
        String lastName = readLine("Enter your lastName :");
        return findContact(firstName, lastName);
    }

    private Optional<Contact> findContact(String name, String family) {
        return contactList.stream()
                .filter(contact -> (contact.getFirstName().equals(name)) && (contact.getLastName().equals(family)))
                .findFirst();
    }

    private void addContact() throws Exception {
        String firstName = readLine("please enter your firstName: ");
        String lastName = readLine("please enter your lastName: ");
        Optional<Contact> searchContact = findContact(firstName, lastName);
        if (searchContact.isPresent())
            throw new Exception("This contact is already exist");
        ArrayList<PhoneNumber> phoneNumbers = addNumber();
        contactList.add(new Contact(firstName, lastName, phoneNumbers));
    }

    private ArrayList<PhoneNumber> addNumber() {
        ArrayList<PhoneNumber> numList = new ArrayList<>();
        int countNum = Integer.parseInt(readLine("How many numbers do you want to enter?:"));
        for (int i = 0; i < countNum; i++) {
            String num = readLine("number:" + (i + 1));
            numList.add(new PhoneNumber(num));
        }
        return numList;
    }

    private String readLine(String msg) {
        System.out.println(msg);
        return input.nextLine();
    }
}
