package educar.rs.exemplo_jpa.repository;

import educar.rs.exemplo_jpa.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

}
