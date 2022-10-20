package capstone.project.repository;

import capstone.project.entity.ReportExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.UUID;

@Repository
public interface ReportExpenseRepository extends JpaRepository<ReportExpenseEntity, BigInteger> {

    ReportExpenseEntity findByExpenseId(UUID expenseId);

    @Transactional
    void deleteByExpenseId(UUID expenseId);
}
