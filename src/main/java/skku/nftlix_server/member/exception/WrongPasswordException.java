package skku.nftlix_server.member.exception;

import skku.nftlix_server.core.exception.error.BadRequestException;

public class WrongPasswordException extends BadRequestException {

    public WrongPasswordException(String loginId) {
        super(String.format("wrong password [%s]", loginId));
    }
}
