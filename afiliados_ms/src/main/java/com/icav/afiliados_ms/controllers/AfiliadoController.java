package com.icav.afiliados_ms.controllers;

import com.icav.afiliados_ms.exceptions.AfiliadoNotFoundException;
import com.icav.afiliados_ms.exceptions.IdDupliclateException;
import com.icav.afiliados_ms.models.Afiliado;
import com.icav.afiliados_ms.models.Contagio;
import com.icav.afiliados_ms.repositories.AfiliadoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    @GetMapping("/mostrarTodosAfiliados")
    List<Afiliado> listarContagiosAfiliado(){

        List<Afiliado> afiliados = afiliadoRepository.findAll();
        return afiliados;
    }

    @PostMapping("/crearAfiliado")
    Afiliado newAfiliado(@RequestBody Afiliado afiliado) {

        if(afiliado.getIdentificacion() == null)
            throw new IdDupliclateException("No se envio un Id - o json vacio");

        Afiliado exists = afiliadoRepository.findById(afiliado.getIdentificacion()).orElse(null);
        if(exists != null)
            throw new IdDupliclateException("El afiliado " + afiliado.getIdentificacion()+" ya existe no se puede crear");

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

    @PutMapping("/modificarAfiliado")
    Afiliado modificarAfiliado(@RequestBody Afiliado afiliado) {

        if(afiliado.getIdentificacion() == null)
            throw new IdDupliclateException("No se envio un Id - o json vacio");

        Afiliado exists = afiliadoRepository.findById(afiliado.getIdentificacion()).orElse(null);
        if(exists == null)
            throw new IdDupliclateException("El afiliado " + afiliado.getIdentificacion()+" no existe");

        if(afiliado.getCorreo() != null)
            exists.setCorreo(afiliado.getCorreo());
        if(afiliado.getDireccion() != null)
            exists.setDireccion(afiliado.getDireccion());
        return afiliadoRepository.save(exists);
    }
}
