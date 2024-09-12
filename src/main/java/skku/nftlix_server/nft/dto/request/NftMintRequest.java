package skku.nftlix_server.nft.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public record NftMintRequest(
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        @Valid
        @NotEmpty
        String id
) {
}
