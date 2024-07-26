package com.example.meatshop.Service;


import com.example.meatshop.Entity.Contact;

import java.util.List;

public interface ContactService {
    Contact sendMessage(Contact contact);
    List<Contact> getAllMessages();
    Contact getMessageById(Long id);
    Long ContactCount();
}
