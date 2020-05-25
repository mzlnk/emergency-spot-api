package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.params.EntityParams;

import java.util.List;
import java.util.Optional;

public interface EntityService<R, E> {

    List<R> findAll(EntityParams<E> params);

    Optional<R> findOne(Long id);

    void createOrUpdate(R entity);

    void delete(R entity);

    void deleteById(Long id);

}
