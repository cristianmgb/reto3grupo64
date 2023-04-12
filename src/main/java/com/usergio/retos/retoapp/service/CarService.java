package com.usergio.retos.retoapp.service;

import com.usergio.retos.retoapp.modelo.entidad.Car;
import com.usergio.retos.retoapp.modelo.repositorio.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public List<Car> getAll(){
        return repository.findAll();
    }

    public Car save(Car car){
        return repository.save(car);
    }

}
