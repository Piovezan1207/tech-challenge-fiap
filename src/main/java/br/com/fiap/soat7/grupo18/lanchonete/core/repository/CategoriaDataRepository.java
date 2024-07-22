package br.com.fiap.soat7.grupo18.lanchonete.core.repository;

import java.util.List;

import br.com.fiap.soat7.grupo18.lanchonete.core.entity.dto.CategoriaDto;
import br.com.fiap.soat7.grupo18.lanchonete.infrastructure.persistence.repository.DataRepository;

public interface CategoriaDataRepository extends DataRepository {

    public List<CategoriaDto> findAll();

}
