package capstone.project.repository;

import capstone.project.entity.MemberListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.UUID;

@Repository
public interface MemberListRepository extends JpaRepository<MemberListEntity, BigInteger> {
    MemberListEntity findBymemberlistId(UUID memberlistId);

    @Transactional
    void deleteBymemberlistId(UUID memberlistId);

}
