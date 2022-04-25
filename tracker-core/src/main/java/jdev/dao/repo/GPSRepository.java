package jdev.dao.repo;

import jdev.GPSPointEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jdev on 21.05.2017.
 */
public interface GPSRepository extends CrudRepository<GPSPointEntity, Integer> {
}
