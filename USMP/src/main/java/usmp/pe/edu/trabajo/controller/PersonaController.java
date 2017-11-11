package usmp.pe.edu.trabajo.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import usmp.pe.edu.trabajo.bean.Persona;
import usmp.pe.edu.trabajo.bean.PersonaRepository;
import usmp.pe.edu.trabajo.bean.Producto;
import usmp.pe.edu.trabajo.bean.ProductoRepository;
import usmp.pe.edu.trabajo.bean.Usuario;
import usmp.pe.edu.trabajo.bean.UsuarioRepository;

@Controller
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepo;

	@Autowired
	private UsuarioRepository usuarioRepo;

	@GetMapping("/agregarPersona")
	public String loadFormProducto(Model model ,  Locale locale) {
		model.addAttribute("persona", new Persona());
		return "personaForm";
	}

	@PostMapping("/agregarPersona")
	public String submitProducto(@Valid Persona persona, BindingResult result ,  Locale locale) {

		if (result.hasErrors()) {
			return "personaForm";
		} else {
			Usuario user = new Usuario();
			user.setStusuario(persona.getUser().getStusuario());
			user.setClave(persona.getUser().getClave());

			usuarioRepo.save(user);

			persona.setUser(user);

			System.out.println("Codigo Usuario :: " + persona.getUser().getCodigo());

			personaRepo.save(persona);

			return "redirect:/listarPersonas";
		}
		

	}

	@GetMapping(value = "/persona/{personaId}/eliminar")
	public String eliminarPerson(@PathVariable("personaId") long codigo, Model model) {
		System.out.println("Codigo : " + codigo);
		personaRepo.delete(codigo);
		return "redirect:/listarPersonas";
	}

	@GetMapping("/listarPersonas")
	public String list(Map<String, Object> model) {
		List<Persona> personas = personaRepo.findAll();
		model.put("personas", personas);
		return "listaPersonas";
	}

	@GetMapping(value = "/persona/{personaId}/edit")
	public String editPerson(@PathVariable("personaId") long codigo, Model model) {
		Persona persona = personaRepo.findOne(codigo);
		System.out.println("Codigo de Edit " + persona.getCodigo());
		model.addAttribute("persona", persona);
		return "personaForm";
	}

}
