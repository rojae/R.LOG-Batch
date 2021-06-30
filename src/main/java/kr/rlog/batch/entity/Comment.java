package kr.rlog.batch.entity;

import kr.rlog.batch.account.Account;
import kr.rlog.batch.common.Status;
import kr.rlog.batch.common.TimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity(name = "TBL_COMMENT")
@NoArgsConstructor
public class Comment extends TimeEntity {

    public Comment(Long id){
        this.id = id;
    }

    @Id @GeneratedValue
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account writer;

    @ManyToOne
    private Post post;

    @Column(columnDefinition = "bigint(20) default '0'", nullable = false)
    private Long parentId;

    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'ENABLE' ")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(columnDefinition = "bigint(5) default '0'", nullable = false)
    private Long likeCount;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Set<CommentLikes> commentLikes = new HashSet<CommentLikes>();


}
