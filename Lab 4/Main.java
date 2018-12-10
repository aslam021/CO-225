
/*
    * Author: Aslam M.M.M
    * Reg.No: E/15/021
    * Lab No: 04
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static int count;
    static Contacts[] contact;

    // a method to print the output contacts
    public static boolean printResult(String[] name) {
        boolean retType = false; // return type
        int j = 1; // counter for output

        System.out.println();
        if (name[0].equals("F")) {
            try {
                for (int i = 0; i < contact.length; i++) {
                    // System.out.println(contact[i].getfName());
                    if (name[1].equalsIgnoreCase(contact[i].getfName())) {
                        System.out.println(j + ". " + contact[i].getfName() + " " + contact[i].getlName() + ": "
                                + contact[i].getNumber());
                        retType = true;
                        j++;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You did not enter the name");
                retType = true;
            }

        } else if (name[0].equals("L")) {
            try {
                for (int i = 0; i < contact.length; i++) {
                    if (name[1].equalsIgnoreCase(contact[i].getlName())) {
                        System.out.println(j + ". " + contact[i].getfName() + " " + contact[i].getlName() + ": "
                                + contact[i].getNumber());
                        retType = true;
                        j++;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You did not enter the name");
                retType = true;
            }

        } else {
            System.out.println("Input should starts with eithor F: or L:");
            retType = true;
        }

        return retType;
    }

    public static void main(String[] args) {

        try {
            String str;

            // count the no of contacts
            BufferedReader read = new BufferedReader(new FileReader("contacts.csv"));
            while ((str = read.readLine()) != null) {
                count++;
            }
            read.close();

            // allocating the array size of contact
            contact = new Contacts[count];

            // create a new object and save the contacts to the array
            BufferedReader in = new BufferedReader(new FileReader("contacts.csv"));

            int i = 0;
            while ((str = in.readLine()) != null) {
                String devide[] = str.split(",");
                contact[i] = new Contacts(devide[0], devide[1], devide[2]);
                i++;
            }
            in.close();

        } catch (IOException e) {
            System.out.println("File not found");
        }

        // getting user input
        System.out.println("\t\t  My Contacts");
        System.out.println("================================================");
        System.out.println("* if you type first name starts with 'F:'");
        System.out.println("* if you type last name starts with 'L:'");
        System.out.println();
        System.out.print("Enter a contact's name: ");
        Scanner keyboard = new Scanner(System.in);
        String name[] = keyboard.nextLine().split(":");

        if (!printResult(name)) {
            System.out.println("No contacts found");
        }
    }
}