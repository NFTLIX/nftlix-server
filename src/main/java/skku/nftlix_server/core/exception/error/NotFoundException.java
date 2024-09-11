package skku.nftlix_server.core.exception.error;

public class NotFoundException extends BaseException {
    public NotFoundException(final String message) {
        super(message);
    }
}