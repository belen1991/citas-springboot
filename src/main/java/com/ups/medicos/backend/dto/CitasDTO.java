package com.ups.medicos.backend.dto;

import com.ups.medicos.backend.enums.MedicosEnum;

public class CitasDTO {
    private MedicosEnum tipo;
    public MedicosEnum getTipo() {
        return tipo;
    }
    public void setTipo(MedicosEnum tipo) {
        this.tipo = tipo;
    }
    private String paciente;
    public String getPaciente() {
        return paciente;
    }
    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
}
