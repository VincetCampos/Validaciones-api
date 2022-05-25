package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Estudiante;

public interface EstudianteService {
	
	public List<Estudiante> lisarEstudiante();
	public Estudiante buscarporId(long id);
	public Estudiante buscarPorNombre(String nombre);
	public void crearEstudiante(Estudiante e);
	public void actualizarEstudiante(long id, Estudiante e);
	public void borrarEstudiante(long id);
}
