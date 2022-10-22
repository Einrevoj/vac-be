package capstone.project.repository;

import capstone.project.entity.InvestmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.UUID;

@Repository
public interface InvestmentRepository  extends JpaRepository<InvestmentEntity, BigInteger> {

    InvestmentEntity findByinvestmentId(UUID investmentId);

    @Transactional
    void deleteByinvestmentId(UUID investmentId);
}
