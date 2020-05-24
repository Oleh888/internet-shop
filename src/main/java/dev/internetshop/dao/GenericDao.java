package dev.internetshop.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<E, K> {

    E create(E element);

    Optional<E> get(K id);

    List<E> getAll();

    E update(E element);

    boolean delete(K id);
}
