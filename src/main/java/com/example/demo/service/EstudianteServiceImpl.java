package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.EstudianteDao;
import com.example.demo.entity.Estudiante;
import com.example.demo.exceptions.NotFoundException;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	EstudianteDao estudianteDao;
	
	@Override
	public List<Estudiante> lisarEstudiante() {
		return (List<Estudiante>) estudianteDao.findAll();
	}

	@Override
	public Estudiante buscarporId(long id) {
		
		Optional<Estudiante> optionalEstudiante = estudianteDao.findById(id);
		
		if(optionalEstudiante.isPresent()) {
			return optionalEstudiante.get();
		
		}else {
			
			throw new NotFoundException("No se encontro el estudiante");
		}
		
		
	}

	@Override
	public void crearEstudiante(Estudiante e) {
		estudianteDao.save(e);
		
	}

	@Override
	public void actualizarEstudiante(long id, Estudiante e) {
		if(estudianteDao.existsById(id)){
			e.setIdEstudiante(id);
			estudianteDao.save(e);
		}else {
			
			throw new NotFoundException("No se encontro al estudiante");
		}
		
	}

	@Override
	public void borrarEstudiante(long id) {
		if(estudianteDao.existsById(id)) {
			estudianteDao.deleteById(id);
			
		}else {
			
			throw new NotFoundException("No se encontro al estudiante");
		}
		
	}

	@Override
	public Estudiante buscarPorNombre(String nombre) {
		
		Optional<Estudiante> optionalNombre = estudianteDao.findByNombreEstudiante(nombre);
		
		if(optionalNombre.isPresent()) {
			
			return optionalNombre.get();
		}else {
			
			throw new NotFoundException("No se encontro al estudiante");
		}
		
	}

	
}
