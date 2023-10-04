package com.ups.medicos.backend.model;

import com.ups.medicos.backend.enums.EventEnum;

public interface Mediator {

	public String notificar(Component com, EventEnum event);

}