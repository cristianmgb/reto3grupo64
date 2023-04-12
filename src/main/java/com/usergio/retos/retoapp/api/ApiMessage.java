package com.usergio.retos.retoapp.api;

import com.usergio.retos.retoapp.modelo.entidad.Messages;
import com.usergio.retos.retoapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin("*")
public class ApiMessage {

    @Autowired
    private MessageService service;

    @GetMapping("/all")
    public List<Messages> getAll() {
        return service.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Messages messages) {
        service.save(messages);
        return ResponseEntity.status(201).build();
    }
}
