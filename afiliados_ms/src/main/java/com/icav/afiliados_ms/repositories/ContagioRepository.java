package com.icav.afiliados_ms.repositories;

import com.icav.afiliados_ms.models.Contagio;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContagioRepository extends MongoRepository <Contagio, Integer> {
    List<Contagio> findByPerson (Integer idPersona);
}
