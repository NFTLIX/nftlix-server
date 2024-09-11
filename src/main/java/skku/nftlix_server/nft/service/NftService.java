package skku.nftlix_server.nft.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import skku.nftlix_server.nft.exception.NftNotFoundException;
import skku.nftlix_server.nft.repository.NftRepository;
import skku.nftlix_server.util.BashService;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class NftService {

    private final NftRepository nftRepository;
    private final BashService bashService;

    private final String NODE_COMMAND = "node";
    private final String NFT_MINT_DIRECTORY = "/home/ubuntu/nft-mint/";
    private final String NFT_MINT_FILE = "scripts/mint-nft.js";

    public void mint(String id) {
        String metadataUrl =
                nftRepository.findById(id).orElseThrow(() -> new NftNotFoundException(id)).getMetadataUrl();

        List<String> generateNFTCommand =
                Arrays.asList("/bin/sh",
                        "-c",
                        bashService.makeCommand(Arrays.asList(
                                "cd",
                                NFT_MINT_DIRECTORY,
                                "&&",
                                ".",
                                "/home/ec2-user/.nvm/nvm.sh",
                                "&&",
                                NODE_COMMAND,
                                NFT_MINT_FILE,
                                metadataUrl)));

        bashService.executeCommand(generateNFTCommand);
    }
}
