package forum.Dao;

import java.util.List;
import java.util.Optional;

/**
 * @param <T> Model
 * @author Edward
 * <p>
 * CRUD interface
 */
public interface CRUDDao<T> {

    /**
     * @param t create
     */
    void save(T t);

    /**
     * @param id read
     * @return Optional
     */
    Optional<T> getById(Long id);

    /**
     * @param t update
     */
    void update(T t);

    /**
     * @param t delete
     */
    void delete(T t);

    /**
     * @return list of models
     */
    List<T> getAll();
}
