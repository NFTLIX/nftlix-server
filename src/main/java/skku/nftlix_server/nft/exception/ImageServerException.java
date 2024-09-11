package skku.nftlix_server.nft.exception;

import skku.nftlix_server.core.exception.error.InternalServerException;

public class ImageServerException extends InternalServerException {

    public ImageServerException() {
        super("error occurred in image server api");
    }
}
