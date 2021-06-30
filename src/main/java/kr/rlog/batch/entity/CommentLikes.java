package kr.rlog.batch.entity;

import kr.rlog.batch.account.Account;
import kr.rlog.batch.common.LikesType;
import kr.rlog.batch.common.TimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity(name = "TBL_COMMENT_LIKES")
@Setter
@Getter
public class CommentLikes extends TimeEntity {

    public CommentLikes(Account account, Comment comment){
        this.account = account;
        this.comment = comment;
        this.status = LikesType.ENABLE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="like_post_seq")
    @SequenceGenerator(name = "like_post_seq", sequenceName = "like_post_seq", initialValue = 1, allocationSize=1)
    private Long id;

    // ENABLE || UNABLE
    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'ENABLE' ")
    @Enumerated(EnumType.STRING)
    private LikesType status;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Comment comment;

}
