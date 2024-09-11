package skku.nftlix_server.member;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import skku.nftlix_server.core.base.BaseEntity;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    private String name;
    private String loginId;
    private String password;

    private Member(String name, String loginId, String password) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
    }

    public static Member createMember(String name, String loginId, String password) {
        return new Member(name, loginId, password);
    }
}
