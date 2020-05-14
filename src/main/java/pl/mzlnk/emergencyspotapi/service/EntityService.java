package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.params.EntityParams;

import java.util.List;
import java.util.Optional;

public interface EntityService<E> {

    List<E> findAll(EntityParams<E> params);

    Optional<E> findOne(Long id);

    void createOrUpdate(E entity);

    void delete(E entity);

    void deleteById(Long id);

}
