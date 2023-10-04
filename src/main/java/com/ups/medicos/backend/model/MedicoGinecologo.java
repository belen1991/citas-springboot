package com.ups.medicos.backend.model;

import com.ups.medicos.backend.enums.EventEnum;

public class MedicoGinecologo extends Component {

	public MedicoGinecologo(Mediator mediador) {
		super(mediador);
	}
	
	public String examenesMedicos() {
		return this.getMediador().notificar(this, EventEnum.EXAMENES);
	}

}