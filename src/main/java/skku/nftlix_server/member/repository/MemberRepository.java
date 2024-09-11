package skku.nftlix_server.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skku.nftlix_server.member.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
