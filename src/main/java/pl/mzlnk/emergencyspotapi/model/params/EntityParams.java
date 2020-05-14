package pl.mzlnk.emergencyspotapi.model.params;

import org.springframework.data.domain.Example;

public interface EntityParams<E> {

    Example<E> toExample();

}
