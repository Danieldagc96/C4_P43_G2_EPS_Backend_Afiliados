package com.icav.afiliados_ms.repositories;

import com.icav.afiliados_ms.models.Afiliado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AfiliadoRepository extends MongoRepository <Afiliado, Integer> {
}
