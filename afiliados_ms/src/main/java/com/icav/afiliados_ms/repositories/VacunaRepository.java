package com.icav.afiliados_ms.repositories;

import com.icav.afiliados_ms.models.Vacuna;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VacunaRepository extends MongoRepository <Vacuna, Integer>{
    List<Vacuna> findByPerson (Integer idPersona);
}
