package skku.nftlix_server.nft.dto.response;

import skku.nftlix_server.member.Member;
import skku.nftlix_server.nft.Nft;

public record SingleNftResponse(
                String id,
                String memberId,
                String memberName,
                String name,
                String description,
                Integer price,
                Double royalty,
                String privilege,
                String mainImageUrl,
                String previewImageUrl,
                String metadataUrl
) {

    public static SingleNftResponse of(Nft nft, Member member) {
        return new SingleNftResponse(
                nft.getId(),
                member.getId(),
                member.getName(),
                nft.getName(),
                nft.getDescription(),
                nft.getPrice(),
                nft.getRoyalty(),
                nft.getPrivilege(),
                nft.getMainImageUrl(),
                nft.getPreviewImageUrl(),
                nft.getMetadataUrl()
        );
    }
}
