package skku.nftlix_server.member.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import skku.nftlix_server.member.Member;

public record MemberResponse(
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        String id,
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
        String name
) {

    public static MemberResponse of(Member member) {
        return new MemberResponse(member.getId(), member.getName());
    }
}
