package skku.nftlix_server.nft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skku.nftlix_server.nft.Nft;

public interface NftRepository extends JpaRepository<Nft, String> {

}
