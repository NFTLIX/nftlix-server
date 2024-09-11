package skku.nftlix_server.nft.exception;

import skku.nftlix_server.core.exception.error.NotFoundException;

public class NftNotFoundException extends NotFoundException {

    public NftNotFoundException(String id) {
        super(String.format("not found nft [%s]", id));
    }
}