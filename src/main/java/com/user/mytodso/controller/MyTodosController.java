package com.user.mytodso.controller;

import com.sun.xml.bind.v2.TODO;
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

@Controller
public class MyTodosController {

    @Autowired
    private MyTodosService service;

    @RequestMapping("welcome")
    public String homePage() {
        return "home";
    }

    @RequestMapping("mytodos")
    public String todosPage(Model model) {
        model.addAttribute("mytodos", new MytodosTO());
        model.addAttribute("statusList", Arrays.asList("todo", "in progress", "done"));
        return "mytodos";
    }

    @PostMapping("add")
    public String SaveOrUpdateTodos(@ModelAttribute MytodosTO todosTO) {
        if (todosTO.getId() != null) {
            Mytodos todos = service.findById(todosTO.getId());
            Mytodos mytodos = new Mytodos();
            mytodos.setId(todosTO.getId());
            mytodos.setTaskName(todosTO.getTaskName());
            mytodos.setStatus(todosTO.getStatus());
            service.saveTodos(mytodos);
        } else {
            Mytodos mytodos = new Mytodos();
            mytodos.setTaskName(todosTO.getTaskName());
            mytodos.setStatus(todosTO.getStatus());
            service.saveTodos(mytodos);
        }
        return "success";
    }

    @RequestMapping("all")
    public String todosAllPage(Model model) {
        model.addAttribute("todosList", service.getAllTodos());
        return "all";
    }

    @RequestMapping("deleteTodos/{id}")
    public String deleteTodos(@PathVariable Long id) {
        service.deleteById(id);
        return "success";
    }

    @RequestMapping("editTodos/{id}")
    public String editTodos(@PathVariable String id,Model model) {
        Mytodos todos = service.findById(Long.parseLong(id));
        MytodosTO to = new MytodosTO();
        to.setId(todos.getId());
        to.setStatus(todos.getStatus());
        to.setTaskName(todos.getTaskName());
        model.addAttribute("mytodos", to);
        model.addAttribute("statusList", Arrays.asList("todo", "in progress", "done"));
        return "edit";
    }


}
