package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Estudiante;
import com.example.demo.service.EstudianteService;

@RestController
@RequestMapping("/estudiantes")

public class EstudianteController {
	
	@Autowired
	EstudianteService estudianteServicio;
	
	@GetMapping()
	public List<Estudiante> listadoEstudiantes(){
		
		return estudianteServicio.lisarEstudiante();
	}
	
	@GetMapping("/{variable}")
	public Estudiante buscarEstudiante(@PathVariable String variable) {
		
		if(variable.matches("-?\\d+")) {
			long id = Long.parseLong(variable);
			
			return estudianteServicio.buscarporId(id);	
			
		}else {
			
			return estudianteServicio.buscarPorNombre(variable);
			
		}
		
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public void crearEstudiante(@Valid @RequestBody Estudiante estudiante) {
		estudianteServicio.crearEstudiante(estudiante);
	}
	
	@PutMapping("/{id}")
	public void actualizarEstudiante(@PathVariable long id, @Valid @RequestBody Estudiante estudiante) {
		estudianteServicio.actualizarEstudiante(id, estudiante);
	}
	
	@DeleteMapping("/{id}")
	public void borrarEstudiante(@PathVariable long id) {
		estudianteServicio.borrarEstudiante(id);
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex){
		
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		
		return errors;
	}
			
			
}
