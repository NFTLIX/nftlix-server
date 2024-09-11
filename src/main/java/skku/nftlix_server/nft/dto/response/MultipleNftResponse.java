package skku.nftlix_server.nft.dto.response;

import skku.nftlix_server.nft.Nft;

public record MultipleNftResponse(
        String id,
        String previewImageUrl,
        Integer price
) {

    public static MultipleNftResponse of(Nft nft) {
        return new MultipleNftResponse(
                nft.getId(),
                nft.getPreviewImageUrl(),
                nft.getPrice()
        );
    }
}
