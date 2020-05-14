package app.repository.repoInterface;

import java.util.List;

public interface IGeneralRepo<T> {
    List<T> findAll();

    T add(T t);

    T edit(T t);

    T remove(T t);

}
