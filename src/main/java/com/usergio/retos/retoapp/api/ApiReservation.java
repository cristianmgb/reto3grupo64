package com.usergio.retos.retoapp.api;

import com.usergio.retos.retoapp.custom.CountClient;
import com.usergio.retos.retoapp.custom.StatusAmount;
import com.usergio.retos.retoapp.modelo.entidad.Reservation;
import com.usergio.retos.retoapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin("*")
public class ApiReservation {

    @Autowired
    private ReservationService service;

    @GetMapping("/all")
    public List<Reservation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable Long id) {
        return service.getFindById(id);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Reservation reservation) {
        service.save(reservation);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Reservation reservation) {
        service.updateReservation(reservation);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.deleteReservation(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/report-dates/{dateA}/{dateB}")
    public List<Reservation> reportDates(@PathVariable String dateA, @PathVariable String dateB) {
        return service.getReservationPeriod(dateA, dateB);
    }

    @GetMapping("/report-status")
    public StatusAmount reportByStatus(){
        return service.getReservationByStatusReport();
    }

    @GetMapping("/report-clients")
    public List<CountClient> reportByClients(){
        return service.getTopClient();
    }
}
