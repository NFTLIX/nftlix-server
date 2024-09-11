package skku.nftlix_server.nft.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import skku.nftlix_server.nft.Nft;

public record NftResponse(
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        @Valid
        @NotEmpty
        String id
) {
}
