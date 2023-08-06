package ZeroBase.StockDividend.persist;

import ZeroBase.StockDividend.model.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

  Optional<MemberEntity> findByUsername(String username);

  boolean existsByUsername(String username);
}
