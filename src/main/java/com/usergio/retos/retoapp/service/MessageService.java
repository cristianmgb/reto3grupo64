package com.usergio.retos.retoapp.service;

import com.usergio.retos.retoapp.modelo.entidad.Messages;
import com.usergio.retos.retoapp.modelo.repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public List<Messages> getAll() {
        return repository.findAll();
    }

    public Messages save(Messages messages) {
        return repository.save(messages);
    }

    public Optional<Messages> getFindById(Long id){
        return repository.findById(id);
    }

    public Messages updateMessage(Messages messages){
        Optional<Messages> messageUpdate = getFindById(messages.getIdMessage());
        if (messageUpdate.isPresent()){
            messageUpdate.get().setMessageText(messages.getMessageText());
            messageUpdate.get().setClient(messages.getClient());
            messageUpdate.get().setCar(messages.getCar());
            return repository.save(messageUpdate.get());
        }else{
            return messages;
        }
    }

    public void deleteMessage(Long id){
        repository.deleteById(id);
    }


}
