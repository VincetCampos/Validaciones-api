package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Estudiante;

public interface EstudianteDao extends CrudRepository<Estudiante, Long>{
	
	public Optional<Estudiante> findByNombreEstudiante(String nombre);

}
