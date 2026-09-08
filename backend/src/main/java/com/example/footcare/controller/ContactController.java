package com.example.footcare.controller;

import com.example.footcare.model.ContactMessage;
import com.example.footcare.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    @Autowired
    private ContactMessageRepository repo;

    @PostMapping
    public ContactMessage create(@RequestBody ContactMessage m) { return repo.save(m); }

    @GetMapping
    public List<ContactMessage> list() { return repo.findAll(); }
}
