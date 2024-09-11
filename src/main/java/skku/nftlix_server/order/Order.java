package skku.nftlix_server.order;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import skku.nftlix_server.core.base.BaseEntity;

@Entity
@Getter
@Table(name = "nft_order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nftId;
    private String memberId;

    private Order(String nftId, String memberId) {
        this.nftId = nftId;
        this.memberId = memberId;
    }

    public static Order createOrder(String nftId, String memberId) {
        return new Order(nftId, memberId);
    }
}
