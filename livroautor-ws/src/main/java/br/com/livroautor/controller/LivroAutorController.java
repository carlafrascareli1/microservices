package br.com.livroautor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.livroautor.dao.LivroAutorDAO;
import br.com.livroautor.model.LivroAutor;

@RestController
@EnableWebMvc
@RequestMapping(value = LivroAutorController.PATH)
public class LivroAutorController {
	
	public static final String PATH = "/livroautor";
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)	
	public ResponseEntity<List<LivroAutor>> get () {
		return new ResponseEntity<List<LivroAutor>>(livroautorDAO.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<LivroAutor> get (@PathVariable("id") int id) {		
		return new ResponseEntity<LivroAutor>(livroautorDAO.findOne(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)	
	public HttpStatus delete (@PathVariable("id") int id) {
		livroautorDAO.delete(id);
		return HttpStatus.OK;
	}
	
	@Autowired
	private LivroAutorDAO livroautorDAO;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<LivroAutor> save (@RequestBody final LivroAutor contatoEntity){
		return new ResponseEntity<LivroAutor>(livroautorDAO.save(contatoEntity), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)	
	public ResponseEntity<LivroAutor> alter (@PathVariable("id") int id, @RequestBody final LivroAutor contatoEntity) {
		return new ResponseEntity<LivroAutor>(livroautorDAO.save(contatoEntity), HttpStatus.OK);
	}
	
}
