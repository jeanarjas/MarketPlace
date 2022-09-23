package com.example.miproject.interfa;

import com.example.miproject.entity.DatosClientesEntity;
import org.springframework.data.repository.CrudRepository;

public interface DatosClientesInterface extends CrudRepository <DatosClientesEntity, Integer> {
}
