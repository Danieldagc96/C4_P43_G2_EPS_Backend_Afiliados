package com.icav.afiliados_ms.controllers;

import com.icav.afiliados_ms.exceptions.AfiliadoNotFoundException;
import com.icav.afiliados_ms.models.Afiliado;
import com.icav.afiliados_ms.models.Vacuna;
import com.icav.afiliados_ms.repositories.AfiliadoRepository;
import com.icav.afiliados_ms.repositories.VacunaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VacunaController {
    private final AfiliadoRepository afiliadoRepository;
    private final VacunaRepository vacunaRepository;

    public VacunaController(AfiliadoRepository afiliadoRepository, VacunaRepository vacunaRepository) {
        this.afiliadoRepository = afiliadoRepository;
        this.vacunaRepository = vacunaRepository;
    }

    @PostMapping("/vacuna/crear")
    Vacuna newVacuna (@RequestBody Vacuna vacuna){
        Afiliado afiliado = afiliadoRepository.findById(vacuna.getIdPersona()).orElse(null);

        if (afiliado == null)
            throw new AfiliadoNotFoundException("No se encontró un afiliado con identifiación: " + vacuna.getIdPersona());

        return vacunaRepository.save(vacuna);
    }

    @GetMapping("/vacunasAfiliado/{identificacion}")
    List<Vacuna> listarVacunasAfiliado(@PathVariable Integer identificacion){
        Afiliado afiliado = afiliadoRepository.findById(identificacion).orElse(null);
        if (afiliado == null)
            throw new AfiliadoNotFoundException("No se encontró un afiliado con identifiación: " + identificacion);

        List<Vacuna> vacunas = vacunaRepository.findByPerson(identificacion);
        return vacunas;
    }

}
