package com.ups.medicos.backend.model;

import java.util.ArrayList;

import com.ups.medicos.backend.enums.EventEnum;

public class ManejadorCitas implements Mediator {

    private ArrayList<Component> medicos;
	
	public ManejadorCitas() {
        this.medicos = new ArrayList<Component>();
	}

    public void agregarMedico(Component medico){
        this.medicos.add(this.medicos.size(), medico);
    }

    public ArrayList<Component> obtenerCitas(){
        return this.medicos;
    }

	@Override
	public String notificar(Component remitente, EventEnum event) {
        var medico = remitente.getClass();
        var mensaje = medico.getName().replace(medico.getPackageName()+".", "");
        switch(event){
            case DERIVAR:
                mensaje += " deriva a un especialista a "+remitente.getPaciente();
                break;
            case EXAMENES:
			    mensaje += " indica que " + remitente.getPaciente() +" necesita examenes";
                break;
            case REAGENDAR:
                mensaje = remitente.getPaciente() + " ha reagendado la cita con "+mensaje;
                break;
            case CANCELAR:
                mensaje = remitente.getPaciente()+ " ha cancelado la cita con "+mensaje;
                break;
        }
        System.out.println(mensaje);
        return mensaje;
	}

}