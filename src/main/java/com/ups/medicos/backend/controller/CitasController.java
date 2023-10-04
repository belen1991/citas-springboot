package com.ups.medicos.backend.controller;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ups.medicos.backend.dto.CitasDTO;
import com.ups.medicos.backend.enums.MedicosEnum;
import com.ups.medicos.backend.model.Component;
import com.ups.medicos.backend.model.ManejadorCitas;
import com.ups.medicos.backend.model.MedicoFamiliar;
import com.ups.medicos.backend.model.MedicoGeneral;
import com.ups.medicos.backend.model.MedicoGinecologo;

@Controller
public class CitasController {
    private static ManejadorCitas manejadorCitas = new ManejadorCitas();
    private static ArrayList<CitasDTO> citas = new ArrayList<CitasDTO>();
    
    @GetMapping("/citasList")
    public String showCitasList(Model model) {
        model.addAttribute("citas", citas); // Add the list of vehicles to the model
        return "citasList"; // Return the name of your Thymeleaf template
    }

    @GetMapping("/reagendar")
    @ResponseBody
    public String reagendar(@RequestParam int index, Model model) {
        Component componente = manejadorCitas.obtenerCitas().get(index);
        if(componente == null)
            throw new RuntimeException("Cita not found");
        
        return componente.reagendarCita();
    }

    @GetMapping("/cancelar")
    @ResponseBody
    public String cancelar(@RequestParam int index, Model model) {
        Component componente = manejadorCitas.obtenerCitas().get(index);
        if(componente == null)
            throw new RuntimeException("Cita not found");

        return componente.cancelarCita();
    }
    
    @GetMapping("/acciones")
    @ResponseBody
    public String acciones(@RequestParam int index, Model model) {
        Component componente = manejadorCitas.obtenerCitas().get(index);
        if(componente == null)
            throw new RuntimeException("Cita not found");
        var clase = componente.getClass();
        switch (clase.getName().replace(clase.getPackageName()+".", "")) {
            case "MedicoFamiliar":
                return ((MedicoFamiliar)componente).derivarEspecialista();
            case "MedicoGeneral":
                return ((MedicoGeneral)componente).derivarEspecialista();
            case "MedicoGinecologo":
                return ((MedicoGinecologo)componente).examenesMedicos();
        }
        return "";
    }
    
    @GetMapping("/createCitaForm")
    public String createCitaForm(Model model) {
        model.addAttribute("citasDTO", new CitasDTO()); // Initialize a new VehicleDTO object
        model.addAttribute("tiposMedico", MedicosEnum.values());
        return "createCita";
    }

    @PostMapping("/createCita")
    public String createCita(@ModelAttribute CitasDTO citaDTO) {
        Component componente = new Component(manejadorCitas);
        switch (citaDTO.getTipo()) {
            case MedicoFamiliar:
                componente = new MedicoFamiliar(manejadorCitas);
                break;
            case MedicoGeneral:
                componente = new MedicoGeneral(manejadorCitas);
                break;
            case MedicoGinecologo:
                componente = new MedicoGinecologo(manejadorCitas);
                break;
        }
        componente.setPaciente(citaDTO.getPaciente());
        manejadorCitas.agregarMedico(componente);
        citas.add(citas.size(), citaDTO);
        return "redirect:/citasList"; // Redirect to the form after creating the vehicle.
    }
}
