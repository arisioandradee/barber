package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Barbeiro;

@Repository
public interface BarbeiroRepository extends JpaRepository<Barbeiro, Integer>{

}
