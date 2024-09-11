package skku.nftlix_server.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skku.nftlix_server.order.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
}
