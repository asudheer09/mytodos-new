package com.user.mytodso.service;

import com.user.mytodso.entity.Mytodos;
import com.user.mytodso.repository.MytodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyTodosService {

    @Autowired
    private MytodosRepository repository;

    public void saveTodos(Mytodos todos){
        repository.save(todos);
    }

    public List<Mytodos> getAllTodos(){
        return repository.findAll();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Mytodos findById(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("record not found"));
    }
}
