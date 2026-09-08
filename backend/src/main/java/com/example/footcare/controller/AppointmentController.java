package com.example.footcare.controller;

import com.example.footcare.model.Appointment;
import com.example.footcare.repository.AppointmentRepository;
import com.example.footcare.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentRepository repo;
    @Autowired
    private ServiceRepository serviceRepo;

    @GetMapping
    public List<Appointment> list() { return repo.findAll(); }

    @PostMapping
    public Appointment create(@RequestBody Appointment a) {
        if (a.getStatus() == null) a.setStatus("Pending");
        return repo.save(a);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment a) {
        return repo.findById(id).map(ex -> {
            ex.setName(a.getName()); ex.setPhone(a.getPhone()); ex.setEmail(a.getEmail());
            ex.setAppointmentAt(a.getAppointmentAt()); ex.setLocation(a.getLocation()); ex.setNotes(a.getNotes());
            ex.setStatus(a.getStatus());
            return ResponseEntity.ok(repo.save(ex));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) { repo.deleteById(id); return ResponseEntity.ok().build(); }
}
