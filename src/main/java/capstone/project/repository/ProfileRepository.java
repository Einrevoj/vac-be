package capstone.project.repository;

import capstone.project.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, BigInteger> {
ProfileEntity findByMemberId(UUID memberId);

@Transactional
    void deleteByMemberId(UUID memberId);

}
