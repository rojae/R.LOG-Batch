package kr.rlog.batch.account;

import kr.rlog.batch.common.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class AccountService {

    // 아래 수정 금지
    // do not edit to true
    private final static boolean deleteAccountStatus = false;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void deleteUnAuthAccount() {
        int delCnt = accountRepository.deleteAllByIsAuth(deleteAccountStatus);
        if (delCnt > 0) {
            log.info("DELETE NON AUTH ACCOUNT : OK ...");
        } else {
            log.info("DELETE NON AUTH ACCOUNT : FAIL ...");
        }
        log.info("DELETE ACCOUNT COUNT : " + delCnt);
    }

    public void printAll() {
        List<Account> accounts = accountRepository.findAll();
        log.info(MessageUtils.getMessage("batch.prefix.left") + "ALL ACCOUNT LIST" + MessageUtils.getMessage("batch.prefix.right"));
        log.info("===== SIZE : " + accounts.size());
        for (Account user : accounts) {
            log.info("===== USER : " + user);
        }
        log.info(MessageUtils.getMessage("batch.postfix.left") + "END" + MessageUtils.getMessage("batch.postfix.right"));
    }

}
