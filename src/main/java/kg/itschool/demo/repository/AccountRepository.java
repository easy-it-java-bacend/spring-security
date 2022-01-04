package kg.itschool.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kg.itschool.demo.model.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
}
