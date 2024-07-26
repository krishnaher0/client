package com.example.meatshop.Service.Impl;


import com.example.meatshop.Entity.Contact;
import com.example.meatshop.Repo.ContactRepo;
import com.example.meatshop.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepo contactRepo;

    @Override
    public Contact sendMessage(Contact contact) {
        return contactRepo.save(contact);
    }

    @Override
    public List<Contact> getAllMessages() {
        return contactRepo.findAll();
    }

    @Override
    public Contact getMessageById(Long id) {
        return contactRepo.findById(id).orElse(null);
    }

    @Override
    public Long ContactCount() {
        return contactRepo.count();
    }
}
