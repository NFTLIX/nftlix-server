package skku.nftlix_server.nft;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Nft {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
    private String mainImageFileName;

    @Column(columnDefinition = "TEXT")
    private String previewImageFileName;

    @Column(columnDefinition = "TEXT")
    private String metadataUrl;

    @Column(columnDefinition = "TEXT")
    private String metadataFileName;

    private Nft(
            String memberId,
            String name,
            String description,
            int price,
            double royalty,
            String privilege,
            String mainImageUrl,
            String previewImageUrl,
            String mainImageFileName,
            String previewImageFileName,
            String metadataUrl,
            String metadataFileName) {
        this.memberId = memberId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.royalty = royalty;
        this.privilege = privilege;
        this.mainImageUrl = mainImageUrl;
        this.previewImageUrl = previewImageUrl;
        this.mainImageFileName = mainImageFileName;
        this.previewImageFileName = previewImageFileName;
        this.metadataUrl = metadataUrl;
        this.metadataFileName = metadataFileName;
    }

    public static Nft createNft(
            String memberId,
            String name,
            String description,
            int price,
            double royalty,
            String privilege,
            String mainImageUrl,
            String previewImageUrl,
            String mainImageFileName,
            String previewImageFileName,
            String metadataUrl,
            String metadataFileName
    ) {
        return new Nft(
                memberId,
                name,
                description,
                price,
                royalty,
                privilege,
                mainImageUrl,
                previewImageUrl,
                mainImageFileName,
                previewImageFileName,
                metadataUrl,
                metadataFileName);
    }
}
