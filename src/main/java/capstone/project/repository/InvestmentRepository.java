package capstone.project.repository;

import capstone.project.entity.InvestmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.UUID;

@Repository
public interface InvestmentRepository  extends JpaRepository<InvestmentEntity, BigInteger> {

    InvestmentEntity findByInvestmentId(UUID investmentId);

    @Transactional
    void deleteByInvestmentId(UUID investmentId);
}
