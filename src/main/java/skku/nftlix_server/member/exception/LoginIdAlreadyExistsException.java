package skku.nftlix_server.member.exception;

import skku.nftlix_server.core.exception.error.AlreadyExistsException;

public class LoginIdAlreadyExistsException extends AlreadyExistsException {

    public LoginIdAlreadyExistsException(String loginId) {
        super(String.format("login id already exists [%s]", loginId));
    }
}