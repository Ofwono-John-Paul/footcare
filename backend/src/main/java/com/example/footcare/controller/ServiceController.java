package com.example.footcare.controller;

import com.example.footcare.model.ServiceEntity;
import com.example.footcare.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {
    @Autowired
    private ServiceRepository repo;

    @GetMapping
    public List<ServiceEntity> list() { return repo.findAll(); }

    @PostMapping
    public ServiceEntity create(@RequestBody ServiceEntity s) { return repo.save(s); }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceEntity> update(@PathVariable Long id, @RequestBody ServiceEntity s) {
        return repo.findById(id).map(ex -> {
            ex.setTitle(s.getTitle()); ex.setDescription(s.getDescription()); ex.setImageUrl(s.getImageUrl());
            return ResponseEntity.ok(repo.save(ex));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) { repo.deleteById(id); return ResponseEntity.ok().build(); }
}
