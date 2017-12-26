package ru.inbox.savinov_vu.commonInterfaces;

import java.util.List;
import java.util.Map;

public interface CRUD<T> {

    default T add(Map<String, T> entityMap) {
        throw new UnsupportedOperationException();
    }

    default void add(List<T> list) {
        throw new UnsupportedOperationException();
    }

    default List<T> getAll() {
        throw new UnsupportedOperationException();
    }

    default boolean delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    default T update(T t) {
        throw new UnsupportedOperationException();
    }
}
