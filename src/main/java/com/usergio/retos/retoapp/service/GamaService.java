package com.usergio.retos.retoapp.service;

import com.usergio.retos.retoapp.modelo.entidad.Gama;
import com.usergio.retos.retoapp.modelo.repositorio.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {
    @Autowired
    private GamaRepository repository;

    /**
     * Method getAll, lista todos los registros de la tabla gama
     * @return List Objet Gama
     */
    public List<Gama> getAll() {
        return repository.findAll();
    }

    /**
     * Method save guarda registro en la tabla gama
     * @param gama
     * @return Objet tipo Gama
     */
    public Gama save (Gama gama) {
        return repository.save(gama);
    }

    public Optional<Gama> getFindById(Long id) {
        return repository.findById(id);
    }

    public Gama updateGama(Gama gama) {
        Optional<Gama> update = this.getFindById(gama.getIdGama());
        if (update.isPresent()){
            update.get().setDescription(gama.getDescription());
            update.get().setName(gama.getName());
            return repository.save(update.get());
        }else {
            return gama;
        }
    }

    public void deleteGama(Long id) {
        repository.deleteById(id);
    }

}
