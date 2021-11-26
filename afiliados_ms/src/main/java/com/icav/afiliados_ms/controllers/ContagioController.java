package com.icav.afiliados_ms.controllers;

import com.icav.afiliados_ms.exceptions.AfiliadoNotFoundException;
import com.icav.afiliados_ms.exceptions.IdDupliclateException;
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

    @PostMapping("/crearContagio")
    Contagio newContagio (@RequestBody Contagio contagio){

        if(contagio.getIdPersona() == null)
            throw new IdDupliclateException("No se envio un IdPersona - o json vacio");

        Afiliado afiliado = afiliadoRepository.findById(contagio.getIdPersona()).orElse(null);

        if (afiliado == null)
            throw new AfiliadoNotFoundException("No se encontró un afiliado con identifiación: " + contagio.getIdPersona());

        return contagioRepository.save(contagio);
    }

    @GetMapping("/mostrarContagiosAfiliado/{identificacion}")
    List<Contagio> listarContagiosAfiliado(@PathVariable Integer identificacion){
        Afiliado afiliado = afiliadoRepository.findById(identificacion).orElse(null);
        if (afiliado == null)
            throw new AfiliadoNotFoundException("No se encontró un afiliado con identifiación: " + identificacion);

        List<Contagio> contagios = contagioRepository.findByIdPersona(identificacion);
        return contagios;
    }

    @PutMapping("/modificarContagio")
    Contagio modificarContagio(@RequestBody Contagio contagio) {

        if(contagio.getIdPersona() == null)
            throw new IdDupliclateException("No se envio un IdPersona - o json vacio");

        List<Contagio> contagios = contagioRepository.findByIdPersona(contagio.getIdPersona());

        if(contagios.isEmpty())
            throw new AfiliadoNotFoundException("No hay contagios para el afiliado con ID: "+contagio.getIdPersona());

        Contagio contagioActivo = null;

        for (Contagio activo : contagios){

            if(activo.getFechaRecuperacion() == null)
                contagioActivo = activo;
        }

        if(contagioActivo.getEstadoEnfermedad() != null)
            contagioActivo.setEstadoEnfermedad(contagio.getEstadoEnfermedad());

        if(contagioActivo.getUbicacionCaso() != null)
            contagioActivo.setUbicacionCaso(contagio.getUbicacionCaso());

        if(contagioActivo.getEstadoRecuperacion() != null)
            contagioActivo.setEstadoRecuperacion(contagio.getEstadoRecuperacion());

        if(contagioActivo.getFechaRecuperacion() != null)
            contagioActivo.setFechaRecuperacion(contagio.getFechaRecuperacion());

        if(contagioActivo.getFechaMuerte() != null)
            contagioActivo.setFechaMuerte(contagio.getFechaMuerte());

        return contagioRepository.save(contagioActivo);
    }

}
