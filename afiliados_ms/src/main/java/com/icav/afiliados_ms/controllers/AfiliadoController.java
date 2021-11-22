package com.icav.afiliados_ms.controllers;

import com.icav.afiliados_ms.exceptions.AfiliadoNotFoundException;
import com.icav.afiliados_ms.models.Afiliado;
import com.icav.afiliados_ms.repositories.AfiliadoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class AfiliadoController {
    private final AfiliadoRepository afiliadoRepository;

    public AfiliadoController(AfiliadoRepository afiliadoRepository){
        this.afiliadoRepository = afiliadoRepository;
    }

    @GetMapping("/afiliado/{identificacion}")
    Afiliado getAfiliado(@PathVariable Integer identificacion){
        return afiliadoRepository.findById(identificacion).orElseThrow(() -> new AfiliadoNotFoundException("No se encontró un afiliado con identifiación: " + identificacion));
    }

    @PostMapping("/afiliado/crear")
    Afiliado newAfiliado(@RequestBody Afiliado afiliado) {
        return afiliadoRepository.save(afiliado);
    }

}
