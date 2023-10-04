package com.ups.medicos.backend.model;

import com.ups.medicos.backend.enums.EventEnum;

public class MedicoFamiliar  extends Component {

    public MedicoFamiliar(Mediator mediador) {
		super(mediador);
	}
	
	public String derivarEspecialista() {
		return this.getMediador().notificar(this, EventEnum.DERIVAR);
	}

}
