package jdev.dao.repo;

import jdev.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jenia on 25.04.22.
 */
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
