package skku.nftlix_server.nft.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ImageResponse(
        @JsonProperty("original_image_url") String originalImageUrl,
        @JsonProperty("converted_image_url") String convertedImageUrl,
        @JsonProperty("metadata_url") String metadataUrl
) {
}
