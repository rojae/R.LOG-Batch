package kr.rlog.batch.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    int deleteAllByIsAuth(boolean isAuth);
}
