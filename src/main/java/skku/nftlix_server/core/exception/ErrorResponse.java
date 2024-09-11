package skku.nftlix_server.core.exception;

public record ErrorResponse(
        int code,
        String message
) {
}