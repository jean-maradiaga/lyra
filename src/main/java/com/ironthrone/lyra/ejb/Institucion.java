package com.ironthrone.lyra.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the institucion database table.
 * 
 */
@Entity
@NamedQuery(name="Institucion.findAll", query="SELECT i FROM Institucion i")
public class Institucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idInstitucion;

	private byte hasSubscription;

	@Column(name="logo_institucion")
	private String logoInstitucion;

	@Column(name="nombre_institucion")
	private String nombreInstitucion;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="institucion")
	private List<Alumno> alumnos;

	//bi-directional many-to-one association to Bitacora
	@OneToMany(mappedBy="institucion")
	private List<Bitacora> bitacoras;

	//bi-directional many-to-one association to Grado
	@OneToMany(mappedBy="institucion")
	private List<Grado> grados;

	//bi-directional many-to-one association to Materia
	@OneToMany(mappedBy="institucion")
	private List<Materia> materias;

	//bi-directional many-to-one association to SubscripcionInstitucion
	@OneToMany(mappedBy="institucion")
	private List<SubscripcionInstitucion> subscripcionInstitucions;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="institucion")
	private List<Usuario> usuarios;

	public Institucion() {
	}

	public int getIdInstitucion() {
		return this.idInstitucion;
	}

	public void setIdInstitucion(int idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public byte getHasSubscription() {
		return this.hasSubscription;
	}

	public void setHasSubscription(byte hasSubscription) {
		this.hasSubscription = hasSubscription;
	}

	public String getLogoInstitucion() {
		return this.logoInstitucion;
	}

	public void setLogoInstitucion(String logoInstitucion) {
		this.logoInstitucion = logoInstitucion;
	}

	public String getNombreInstitucion() {
		return this.nombreInstitucion;
	}

	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno addAlumno(Alumno alumno) {
		getAlumnos().add(alumno);
		alumno.setInstitucion(this);

		return alumno;
	}

	public Alumno removeAlumno(Alumno alumno) {
		getAlumnos().remove(alumno);
		alumno.setInstitucion(null);

		return alumno;
	}

	public List<Bitacora> getBitacoras() {
		return this.bitacoras;
	}

	public void setBitacoras(List<Bitacora> bitacoras) {
		this.bitacoras = bitacoras;
	}

	public Bitacora addBitacora(Bitacora bitacora) {
		getBitacoras().add(bitacora);
		bitacora.setInstitucion(this);

		return bitacora;
	}

	public Bitacora removeBitacora(Bitacora bitacora) {
		getBitacoras().remove(bitacora);
		bitacora.setInstitucion(null);

		return bitacora;
	}

	public List<Grado> getGrados() {
		return this.grados;
	}

	public void setGrados(List<Grado> grados) {
		this.grados = grados;
	}

	public Grado addGrado(Grado grado) {
		getGrados().add(grado);
		grado.setInstitucion(this);

		return grado;
	}

	public Grado removeGrado(Grado grado) {
		getGrados().remove(grado);
		grado.setInstitucion(null);

		return grado;
	}

	public List<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public Materia addMateria(Materia materia) {
		getMaterias().add(materia);
		materia.setInstitucion(this);

		return materia;
	}

	public Materia removeMateria(Materia materia) {
		getMaterias().remove(materia);
		materia.setInstitucion(null);

		return materia;
	}

	public List<SubscripcionInstitucion> getSubscripcionInstitucions() {
		return this.subscripcionInstitucions;
	}

	public void setSubscripcionInstitucions(List<SubscripcionInstitucion> subscripcionInstitucions) {
		this.subscripcionInstitucions = subscripcionInstitucions;
	}

	public SubscripcionInstitucion addSubscripcionInstitucion(SubscripcionInstitucion subscripcionInstitucion) {
		getSubscripcionInstitucions().add(subscripcionInstitucion);
		subscripcionInstitucion.setInstitucion(this);

		return subscripcionInstitucion;
	}

	public SubscripcionInstitucion removeSubscripcionInstitucion(SubscripcionInstitucion subscripcionInstitucion) {
		getSubscripcionInstitucions().remove(subscripcionInstitucion);
		subscripcionInstitucion.setInstitucion(null);

		return subscripcionInstitucion;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setInstitucion(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setInstitucion(null);

		return usuario;
	}

}