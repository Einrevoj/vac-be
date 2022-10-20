package capstone.project.repository;


import capstone.project.entity.ProfileEntity;
import capstone.project.entity.ReportIncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.UUID;

@Repository
public interface ReportIncomeRepository extends JpaRepository<ReportIncomeEntity, BigInteger> {

ReportIncomeEntity findByIncomeId(UUID incomeId);

    @Transactional
    void deleteByIncomeId(UUID incomeId);
}
