package com.cimol.crudapp.controller;

import com.cimol.crudapp.model.Pedido;
import com.cimol.crudapp.service.PedidoService;
import com.cimol.crudapp.service.ClienteService;
import com.cimol.crudapp.service.ProdutoService;
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
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidoService.findAll());
        return "pedido/listar";
    }

    @GetMapping("/novo")
    public String novo(Pedido pedido, Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("produtos", produtoService.findAll());
        return "pedido/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Pedido pedido, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/form";
        }
        pedidoService.save(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("pedido", pedidoService.findById(id));
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("produtos", produtoService.findAll());
        return "pedido/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        pedidoService.delete(id);
        return "redirect:/pedidos";
    }
}

