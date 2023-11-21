package squad25.comercioFacil.repositoryes;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import squad25.comercioFacil.models.Enterprise;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long>{
	@Query
	(value = "SELECT * FROM enterprise WHERE id_user= :idUser", nativeQuery = true)
	public List<Enterprise> findAllByIdUser(@Param("idUser") Long user);	
}