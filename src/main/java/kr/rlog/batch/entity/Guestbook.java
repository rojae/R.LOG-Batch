package kr.rlog.batch.entity;

import kr.rlog.batch.account.Account;
import kr.rlog.batch.common.Status;
import kr.rlog.batch.common.TimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity(name = "TBL_GUESTBOOK")
public class Guestbook extends TimeEntity {

    public Guestbook(){

    }

    public Guestbook(Account writer, String content, Status status, Long parentId){
        this.writer = writer;
        this.content = content;
        this.status = status;
        this.parentId = parentId;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "parentId", columnDefinition = "bigint(20) default '0' ")
    private Long parentId;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account writer;

    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'ENABLE' ")
    @Enumerated(EnumType.STRING)
    private Status status;

}
