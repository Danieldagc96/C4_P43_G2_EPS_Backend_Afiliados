package com.icav.afiliados_ms.controllers;

import com.icav.afiliados_ms.exceptions.AfiliadoNotFoundException;
import com.icav.afiliados_ms.models.Afiliado;
import com.icav.afiliados_ms.models.Contagio;
import com.icav.afiliados_ms.repositories.AfiliadoRepository;
import com.icav.afiliados_ms.repositories.ContagioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContagioController {
    private final AfiliadoRepository afiliadoRepository;
    private final ContagioRepository contagioRepository;

    public ContagioController(AfiliadoRepository afiliadoRepository, ContagioRepository contagioRepository) {
        this.afiliadoRepository = afiliadoRepository;
        this.contagioRepository = contagioRepository;
    }

    @PostMapping("/contagio/crear")
    Contagio newContagio (@RequestBody Contagio contagio){
        Afiliado afiliado = afiliadoRepository.findById(contagio.getIdPersona()).orElse(null);

        if (afiliado == null)
            throw new AfiliadoNotFoundException("No se encontró un afiliado con identifiación: " + contagio.getIdPersona());

        return contagioRepository.save(contagio);
    }

    @GetMapping("/contagiosAfiliado/{identificacion}")
    List<Contagio> listarContagiosAfiliado(@PathVariable Integer identificacion){
        Afiliado afiliado = afiliadoRepository.findById(identificacion).orElse(null);
        if (afiliado == null)
            throw new AfiliadoNotFoundException("No se encontró un afiliado con identifiación: " + identificacion);

        List<Contagio> contagios = contagioRepository.findByIdPersona(identificacion);
        return contagios;
    }

}
