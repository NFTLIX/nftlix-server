package skku.nftlix_server.member.exception;

import skku.nftlix_server.core.exception.error.NotFoundException;

public class MemberNotFoundException extends NotFoundException {

    public MemberNotFoundException(String loginId) {
        super(String.format("not found member [%s]", loginId));
    }
}
