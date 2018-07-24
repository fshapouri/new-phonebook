package ui;

import service.PhoneBookService;

import java.util.Scanner;

public class PhoneBookUi {
    PhoneBookDto pbDto = new PhoneBookDto();
    PhoneBookService pbService =new PhoneBookService();

    public void insertPhoneBook(){

        System.out.println("please Enter name of your phonebook");
        Scanner input = new Scanner(System.in);
        String phoneBookName=input.next();

        pbDto.setPhonebookName(phoneBookName);
        pbService.insertPhoneBook(pbDto);

    }

}
