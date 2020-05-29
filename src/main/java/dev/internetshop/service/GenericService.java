package dev.internetshop.service;

import java.util.List;

public interface GenericService<E, K> {

    E get(K id);

    List<E> getAll();

    boolean delete(K id);
}
