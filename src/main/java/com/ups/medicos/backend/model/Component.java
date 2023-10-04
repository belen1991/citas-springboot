package com.ups.medicos.backend.model;

import com.ups.medicos.backend.enums.EventEnum;

public class Component {
    
	private Mediator mediador;
    private String paciente;
    
	public Component(Mediator mediador) {
		this.mediador = mediador;
	}

	public String cancelarCita() {
		return mediador.notificar(this, EventEnum.CANCELAR);		 
	};
	
	public String reagendarCita() {
		return mediador.notificar(this, EventEnum.REAGENDAR);
	}

	public Mediator getMediador() {
		return mediador;
	}

	public void setMediador(Mediator mediador) {
		this.mediador = mediador;
	}
    
	public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

}
