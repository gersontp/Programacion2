package usmp.pe.edu.trabajo.controller;

import java.util.List;
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

import usmp.pe.edu.trabajo.bean.Producto;
import usmp.pe.edu.trabajo.bean.ProductoRepository;
import usmp.pe.edu.trabajo.bean.Usuario;
import usmp.pe.edu.trabajo.bean.UsuarioRepository;

@Controller
public class AddUsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepo;
	@Autowired
	private ProductoRepository productoRepo;

	@RequestMapping(value = "/")
	public String login(Model model, Locale locale) {
		model.addAttribute("usuario", new Usuario());
		System.out.println("Acceder GET Usuario");

		Usuario user = new Usuario();
		user.setStusuario("administrador");
		user.setClave("12345");

		usuarioRepo.save(user);
		model.addAttribute("estado", "existe");
		return "index";
	}

	private void crearProductos() {
		String productos[] = { "Mesa", "Silla", "Cama", "Ropero", "Sillon", "Laptop", "Mesa de cuadros",
				"Mesa rectangular", "Silla doble", "Sillon color negro" };
		Integer numero[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Double precios[] = { 12.21, 212.2, 332.1, 42.3, 50.3, 632.2, 7.2, 8.4, 9.4, 102.2 };
		for (int i = 0; i < 5; i++) {
			Producto producto = new Producto();
			producto.setNombre(productos[i]);
			producto.setCantidad(numero[i]);
			producto.setPrecio(precios[i]);
			productoRepo.save(producto);
		}

	}

	@PostMapping("/acceder")
	public String submitUsuario(@ModelAttribute Usuario usuario, Model model,  Locale locale) {


		List<Usuario> usuarios = usuarioRepo.findUsuario(usuario.getStusuario(), usuario.getClave());

		for (Usuario usuario2 : usuarios) {
			this.crearProductos();
			return "inicio";
		}
		model.addAttribute("estado", "no_existe");
		return "index";
		

	}
}
