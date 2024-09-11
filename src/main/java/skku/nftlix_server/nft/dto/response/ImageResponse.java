package skku.nftlix_server.nft.dto.response;

public record ImageResponse(
        String originalImageUrl,
        String convertedImageUrl,
        String metadataUrl
) {
}
