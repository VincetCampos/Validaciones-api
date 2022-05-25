package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "estudiantes")
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstudiante;
	
	@NotBlank(message = "Se necesita el nombre del estudiante")
	@Column(name = "nombres")
	private String nombreEstudiante;
	
	@NotBlank(message = "Se necesita del correo electronico")
	@Email(message = "No es un correo valido")
	@Column(name = "emails")
	private String emailEstudiante;
	
	@NotBlank(message = "Se necesita el carnet del estudiante")
	@Column(name = "carnets")
	private String carnetEstudiante;
	
	@Min(value = 0)
	@Max(value = 100)
	@Column(name = "promedios")
	private int promedioEstudiante;
	

	@NotNull(message = "El tiempo no debe ser nulo")
	@Column(name = "fechas")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	

	public Long getIdEstudiante() {
		return idEstudiante;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public String getEmailEstudiante() {
		return emailEstudiante;
	}

	public String getCarnetEstudiante() {
		return carnetEstudiante;
	}

	public int getPromedioEstudiante() {
		return promedioEstudiante;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setIdEstudiante(Long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public void setEmailEstudiante(String emailEstudiante) {
		this.emailEstudiante = emailEstudiante;
	}

	public void setCarnetEstudiante(String carnetEstudiante) {
		this.carnetEstudiante = carnetEstudiante;
	}

	public void setPromedioEstudiante(int promedioEstudiante) {
		this.promedioEstudiante = promedioEstudiante;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
