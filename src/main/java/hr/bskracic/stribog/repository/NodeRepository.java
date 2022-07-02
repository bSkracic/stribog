package hr.bskracic.stribog.repository;

import hr.bskracic.stribog.repository.model.Node;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends CrudRepository<Node, Long> {

}
