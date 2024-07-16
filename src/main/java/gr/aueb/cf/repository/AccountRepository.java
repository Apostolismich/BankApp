package gr.aueb.cf.repository;

import gr.aueb.cf.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
