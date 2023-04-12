package com.usergio.retos.retoapp.service;

import com.usergio.retos.retoapp.modelo.entidad.Messages;
import com.usergio.retos.retoapp.modelo.repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Messages> getAll() {
        return messageRepository.findAll();
    }

    public Messages save(Messages messages) {
        return messageRepository.save(messages);
    }

}
