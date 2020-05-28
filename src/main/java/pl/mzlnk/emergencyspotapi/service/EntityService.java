package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.params.EntityParams;

import java.util.List;
import java.util.Optional;

public interface EntityService<R, D, N, E> {

    List<R> findAll(EntityParams<E> params);

    Optional<D> findOne(Long id);

    D create(N entity);

    void deleteById(Long id);

}
