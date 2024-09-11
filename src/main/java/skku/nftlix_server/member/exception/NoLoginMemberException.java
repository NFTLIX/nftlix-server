package skku.nftlix_server.member.exception;

import skku.nftlix_server.core.exception.error.BadRequestException;

public class NoLoginMemberException extends BadRequestException {

    public NoLoginMemberException() {
        super("no login member");
    }
}