package squad25.comercioFacil.repositoryes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import squad25.comercioFacil.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query
	(value = "SELECT * FROM products WHERE id_enterprise= :idEnterprise", nativeQuery = true)
	public List<Product> findAllByIdEnterprise(@Param("idEnterprise") Long enterprise);
}
