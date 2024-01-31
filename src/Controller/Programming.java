package Controller;

import Model.Contact;
import Model.Library;
import Model.Validation;
import View.Menu;

import java.util.ArrayList;

public class Programming extends Menu {
    static String[] mchoice = {
            "Add a contact",
            "Display all contacts",
            "Delete a contact",
            "Exit"};
    protected Library week5;
    ArrayList<Contact> list;

    public Programming() {
        super("Contact Management Program", mchoice);
        week5 = new Library();
        list = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        if (n == mchoice.length) System.exit(0);

        switch (n) {
            case 1: //add
                addContact();
                break;

            case 2: //display
                displayContact();
                break;

            case 3: //delete
                deleteContact();
                break;

            case 4:
                System.out.println("Bye~~~~");
                System.exit(0);
        }
    }

    //allow user create contact
    public void addContact() {
        System.out.print("Enter id contact: ");
        int contactId = Validation.checkInputInt();
        System.out.print("Enter first name: ");
        String firstName = Validation.checkInputString();
        System.out.print("Enter last name: ");
        String lastName = Validation.checkInputString();
        System.out.print("Enter group: ");
        String group = Validation.checkInputString();
        System.out.print("Enter address: ");
        String address = Validation.checkInputString();
        System.out.print("Enter phone: ");
        String phone = Validation.checkInputPhone();
        list.add(new Contact(contactId, firstName + lastName, group, address,
                phone, firstName, lastName));
        System.out.println("Add successful.");
    }

    //allow user display all contact
    /*public void displayContact(ArrayList<Contact> lc) {
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        //print information of contact from first to last list contact
        for (Contact contact : lc) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getContactId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }*/
    public void displayContact() {
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        // print information of contact from first to last list contact
        for (Contact contact : list) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getContactId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }
    //allow user delete contact
    /*public void deleteContact(ArrayList<Contact> lc) {
        System.out.print("Enter id: ");
        int idDelete = Validation.checkInputInt();
        Contact contactDelete = getContactById(lc, idDelete);
        if (contactDelete == null) {
            System.out.println("Not found contact.");
            return;
        } else {
            lc.remove(contactDelete);
        }
        System.out.println("Delete successful.");
    }*/
// allow user delete contact
    public void deleteContact() {
        System.out.print("Enter id: ");
        int idDelete = Validation.checkInputInt();
        Contact contactDelete = getContactById(idDelete);
        if (contactDelete == null) {
            System.out.println("Not found contact.");
            return;
        } else {
            list.remove(contactDelete);
        }
        System.out.println("Delete successful.");
    }

    //get contact by id
    /*public static Contact getContactById(ArrayList<Contact> lc, int idDelete) {
        for (Contact contact : lc) {
            if (contact.getContactId() == idDelete) {
                return contact;
            }
        }
        return null;
    }*/
    // get contact by id
    public Contact getContactById(int idDelete) {
        for (Contact contact : list) {
            if (contact.getContactId() == idDelete) {
                return contact;
            }
        }
        return null;
    }

}
