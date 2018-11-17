package br.com.demo.spring.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.demo.spring.model.Usuario;
import br.com.demo.spring.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public String userForm(Locale locale, Model model) {
		model.addAttribute("usuarios", usuarioService.listar());
		return "usuarios";
	}
	
	@ModelAttribute("usuario")
    public Usuario retornarFormUsuarioObject() {
        return new Usuario();
    }

	@PostMapping("/usuario/adicionar")
	public String salvarUsuario(@ModelAttribute("usuario") @Valid Usuario usuario, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("usuario", usuarioService.listar());
			return "usuarios";
		}

		usuarioService.salvar(usuario);
		return "redirect:/";
	}
}
