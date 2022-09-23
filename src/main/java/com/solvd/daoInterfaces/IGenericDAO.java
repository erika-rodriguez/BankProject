package  com.solvd.daoInterfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IGenericDAO<T,K> {
    //Dao interface defines an abstract API that performs CRUD operations on objects of type T

    T getOne (K id);
    List<T> getAll();
    void insert (T t);
    void update (T t,K id);
    void delete (K id);
}
