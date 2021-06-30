package kr.rlog.batch.entity;

import kr.rlog.batch.account.Account;
import kr.rlog.batch.common.MailType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "TBL_MAIL")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Mail {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Account account;

    // 돔명이인은 존재할 수 있다
    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "email", nullable = false)
    private String email;

    // 랜던 인증키
    @Column(name = "secretKey", nullable = false)
    private String secretKey;

    // 보낸 날짜
    @Column(name = "sentDate", nullable = false)
    @CreatedDate
    private LocalDateTime sentDate;

    // 만료시간
    @Column(name = "expireDate", nullable = false)
    private LocalDateTime expireDate;

    // 이메일 인증 여부
    @Column(name = "isAuth", nullable = true, columnDefinition = "TINYINT DEFAULT 0", length = 1)
    private boolean auth;

    // 메일의 용도
    @Column(name= "type", nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'USER_SIGNUP' ")
    @Enumerated(EnumType.STRING)
    private MailType mailType;

}

