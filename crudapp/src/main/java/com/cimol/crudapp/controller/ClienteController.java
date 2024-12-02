package com.cimol.crudapp.controller;

import com.cimol.crudapp.model.Cliente;
import com.cimol.crudapp.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "cliente/listar";
    }

    @GetMapping("/novo")
    public String novo(Cliente cliente) {
        return "cliente/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "cliente/form";
        }
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "cliente/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        clienteService.delete(id);
        return "redirect:/clientes";
    }
}

