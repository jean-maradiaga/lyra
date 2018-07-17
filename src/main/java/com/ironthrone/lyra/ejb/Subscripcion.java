package com.ironthrone.lyra.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the subscripcion database table.
 * 
 */
@Entity
@NamedQuery(name="Subscripcion.findAll", query="SELECT s FROM Subscripcion s")
public class Subscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSubscripcion;

	@Column(name="estado_subscripcion")
	private byte estadoSubscripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	//bi-directional many-to-one association to SubscripcionInstitucion
	@OneToMany(mappedBy="subscripcion")
	private List<SubscripcionInstitucion> subscripcionInstitucions;

	public Subscripcion() {
	}

	public int getIdSubscripcion() {
		return this.idSubscripcion;
	}

	public void setIdSubscripcion(int idSubscripcion) {
		this.idSubscripcion = idSubscripcion;
	}

	public byte getEstadoSubscripcion() {
		return this.estadoSubscripcion;
	}

	public void setEstadoSubscripcion(byte estadoSubscripcion) {
		this.estadoSubscripcion = estadoSubscripcion;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public List<SubscripcionInstitucion> getSubscripcionInstitucions() {
		return this.subscripcionInstitucions;
	}

	public void setSubscripcionInstitucions(List<SubscripcionInstitucion> subscripcionInstitucions) {
		this.subscripcionInstitucions = subscripcionInstitucions;
	}

	public SubscripcionInstitucion addSubscripcionInstitucion(SubscripcionInstitucion subscripcionInstitucion) {
		getSubscripcionInstitucions().add(subscripcionInstitucion);
		subscripcionInstitucion.setSubscripcion(this);

		return subscripcionInstitucion;
	}

	public SubscripcionInstitucion removeSubscripcionInstitucion(SubscripcionInstitucion subscripcionInstitucion) {
		getSubscripcionInstitucions().remove(subscripcionInstitucion);
		subscripcionInstitucion.setSubscripcion(null);

		return subscripcionInstitucion;
	}

}