package com.ironthrone.lyra.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCategoria;

	@Column(name="descripcion_categoria")
	private String descripcionCategoria;

	@Column(name="estado_categoria")
	private byte estadoCategoria;

	@Column(name="nombre_categoria")
	private String nombreCategoria;

	private int tarea_idTarea;

	//bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy="categoria")
	private List<Tarea> tareas;

	public Categoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcionCategoria() {
		return this.descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

	public byte getEstadoCategoria() {
		return this.estadoCategoria;
	}

	public void setEstadoCategoria(byte estadoCategoria) {
		this.estadoCategoria = estadoCategoria;
	}

	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public int getTarea_idTarea() {
		return this.tarea_idTarea;
	}

	public void setTarea_idTarea(int tarea_idTarea) {
		this.tarea_idTarea = tarea_idTarea;
	}

	public List<Tarea> getTareas() {
		return this.tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Tarea addTarea(Tarea tarea) {
		getTareas().add(tarea);
		tarea.setCategoria(this);

		return tarea;
	}

	public Tarea removeTarea(Tarea tarea) {
		getTareas().remove(tarea);
		tarea.setCategoria(null);

		return tarea;
	}

}