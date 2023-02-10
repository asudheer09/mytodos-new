package com.user.mytodso.controller;

import com.user.mytodso.domain.MytodosTO;
import com.user.mytodso.entity.Mytodos;
import com.user.mytodso.service.MyTodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@RequestMapping("mytodos")
@Controller
public class MyTodosController {

    @Autowired
    private MyTodosService service;

    @RequestMapping("welcome")
    public  String homePage(){
        return "home";
    }

    @RequestMapping("mytodos")
    public String todosPage(Model model){
        model.addAttribute("mytodos", new MytodosTO());
        model.addAttribute("statusList",Arrays.asList("todos","in progress","done"));
        return "mytodos";
    }

    @PostMapping("add")
    public String SaveTodos(@ModelAttribute MytodosTO todosTO){
        Mytodos mytodos= new Mytodos();
        mytodos.setTaskName(todosTO.getTaskName());
        mytodos.setStatus(todosTO.getStatus());
        service.saveTodos(mytodos);
        return "success";
    }

    @RequestMapping("all")
    public String todosAllPage(Model model){
        model.addAttribute("todosList",service.getAllTodos());
        return "all";
    }

    @RequestMapping("deleteTodos/{id}")
    public String deleteTodos(@PathVariable Long id){
        service.deleteById(id);
        return "success";
    }
}
