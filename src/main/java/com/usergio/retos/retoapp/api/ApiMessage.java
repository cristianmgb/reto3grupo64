package com.usergio.retos.retoapp.api;

import com.usergio.retos.retoapp.modelo.entidad.Messages;
import com.usergio.retos.retoapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<Messages> getMessage(@PathVariable Long id){
        return service.getFindById(id);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Messages messages) {
        service.save(messages);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity update (@RequestBody Messages messages){
        service.updateMessage(messages);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Long id){
        service.deleteMessage(id);
        return ResponseEntity.status(201).build();
    }
}
