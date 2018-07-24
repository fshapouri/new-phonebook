package service;

import dao.PhoneBookDao;
import ui.PhoneBookDto;

public class PhoneBookService{

    public void insertPhoneBook(PhoneBookDto phoneBookDto){

        PhoneBookEntity pbEntity=new PhoneBookEntity();
        pbEntity.setPhonebookName(phoneBookDto.getPhonebookName());

        PhoneBookDao pbDao=new PhoneBookDao();
        pbDao.insertPhoneBook(pbEntity);
    }

}
