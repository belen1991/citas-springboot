package com.ups.medicos.backend.model;

import com.ups.medicos.backend.enums.EventEnum;

public class MedicoGeneral extends Component {

	public MedicoGeneral(Mediator mediador) {
		super(mediador);
	}

	public String derivarEspecialista() {
		return this.getMediador().notificar(this, EventEnum.DERIVAR);
	}
}
