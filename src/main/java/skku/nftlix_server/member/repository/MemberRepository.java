package skku.nftlix_server.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skku.nftlix_server.member.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findByLoginId(String loginId);
    boolean existsByLoginId(String loginId);
}
