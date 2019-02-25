package forum.Service;

import java.util.List;

/**
 * 22.02.2019 14:40
 *
 * @param <T> Model
 * @author Edward
 * <p>
 * CRUD interface
 */
public interface CRUDService<T> {
    /**
     * @param t create
     */
    void save(T t);

    /**
     * @param id read
     * @return T
     */
    T getById(Long id);

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
