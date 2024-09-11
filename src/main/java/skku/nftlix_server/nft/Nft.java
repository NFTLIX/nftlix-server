package skku.nftlix_server.nft;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import skku.nftlix_server.core.base.BaseEntity;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Nft extends BaseEntity {

    @Id
    private String id;

    private String memberId;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int price;

    private double royalty;

    @Column(columnDefinition = "TEXT")
    private String privilege;

    @Column(columnDefinition = "TEXT")
    private String mainImageUrl;

    @Column(columnDefinition = "TEXT")
    private String previewImageUrl;

    @Column(columnDefinition = "TEXT")
    private String metadataUrl;

    private Nft(
            String id,
            String memberId,
            String name,
            String description,
            int price,
            double royalty,
            String privilege,
            String mainImageUrl,
            String previewImageUrl,
            String metadataUrl) {
        this.id = id;
        this.memberId = memberId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.royalty = royalty;
        this.privilege = privilege;
        this.mainImageUrl = mainImageUrl;
        this.previewImageUrl = previewImageUrl;
        this.metadataUrl = metadataUrl;
    }

    public static Nft createNft(
            String id,
            String memberId,
            String name,
            String description,
            int price,
            double royalty,
            String privilege,
            String mainImageUrl,
            String previewImageUrl,
            String metadataUrl
    ) {
        return new Nft(
                id,
                memberId,
                name,
                description,
                price,
                royalty,
                privilege,
                mainImageUrl,
                previewImageUrl,
                metadataUrl);
    }
}
