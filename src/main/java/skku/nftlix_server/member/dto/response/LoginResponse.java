package skku.nftlix_server.member.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public record LoginResponse(
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        @Valid
        @NotEmpty
        String id
) {
}
