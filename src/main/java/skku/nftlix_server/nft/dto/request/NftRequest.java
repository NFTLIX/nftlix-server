package skku.nftlix_server.nft.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NftRequest(
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        @Valid
        @NotEmpty
        String name,
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        @Valid
        @NotEmpty
        String description,
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        @Valid
        @NotNull
        Integer price,
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        @Valid
        @NotNull
        Double royalty,
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        @Valid
        @NotEmpty
        String privilege,
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        @Valid
        @NotEmpty
        String filter
) {
}
