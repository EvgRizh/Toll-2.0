package jdev.dao.repo;

import jdev.GPSPointEntity;
import jdev.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jenia on 25.04.22.
 */
public interface GPSPointRepository extends CrudRepository<GPSPointEntity, Integer> {
}
