package com.icav.afiliados_ms.controllers;

import com.icav.afiliados_ms.exceptions.AfiliadoNotFoundException;
import com.icav.afiliados_ms.exceptions.IdDupliclateException;
import com.icav.afiliados_ms.models.Afiliado;
import com.icav.afiliados_ms.repositories.AfiliadoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AfiliadoController {
    private final AfiliadoRepository afiliadoRepository;

    public AfiliadoController(AfiliadoRepository afiliadoRepository) {
        this.afiliadoRepository = afiliadoRepository;
    }

    @GetMapping("/mostrarAfiliado/{identificacion}")
    Afiliado getAfiliado(@PathVariable Integer identificacion) {
        return afiliadoRepository.findById(identificacion).orElseThrow(() -> new AfiliadoNotFoundException("No se encontró un afiliado con identifiación: " + identificacion));
    }

    @PostMapping("/crearAfiliado")
    Afiliado newAfiliado(@RequestBody Afiliado afiliado) {
        Afiliado exists = afiliadoRepository.findById(afiliado.getIdentificacion()).orElse(null);
        if(exists != null)
            throw new IdDupliclateException("El usuario " + afiliado.getIdentificacion()+" ya existe no se puede crear");
        return afiliadoRepository.save(afiliado);
    }

    @DeleteMapping("/eliminarAfiliado/{identificacion}")
    public Map<String, Boolean> deleteAfiliado(@PathVariable Integer identificacion) {

        Afiliado afiliado = afiliadoRepository.findById(identificacion).orElseThrow(()-> new AfiliadoNotFoundException("El afiliado con identificacion: " + identificacion+ " No existe"));

        afiliadoRepository.delete(afiliado);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", Boolean.TRUE);
        System.out.println(response);
        return response;
    }
}
