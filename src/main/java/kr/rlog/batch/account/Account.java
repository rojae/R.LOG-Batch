package kr.rlog.batch.account;

import kr.rlog.batch.common.PlatformType;
import kr.rlog.batch.common.TimeEntity;
import kr.rlog.batch.entity.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "TBL_ACCOUNT")
@Getter
@Setter
public class Account extends TimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "platformType", nullable = false, columnDefinition = "VARCHAR(10) DEFAULT 'RLOG' ")
    @Enumerated(EnumType.STRING)
    private PlatformType platformType;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "accessToken")
    private String accessToken;

    @Column(name = "refreshToken")
    private String refreshToken;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "profileImage")
    private String profileImage;

    @Column(name = "role", columnDefinition = "VARCHAR(255) DEFAULT 'USER' ")
    private String role;

    @Column(name = "recvMail", columnDefinition = "TINYINT DEFAULT 0", length = 1)
    private boolean recvMail;

    @Column(name = "isAuth", columnDefinition = "TINYINT DEFAULT 0", length = 1)
    private boolean isAuth;

    // 메일 객체의 경우, 미승인 계정 삭제할떄 함께 삭제가 되어야 한다.
    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private Set<Mail> mails = new HashSet<Mail>();

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private Set<Post> posts = new HashSet<Post>();

    @OneToMany(mappedBy = "writer")
    private Set<Comment> comments = new HashSet<Comment>();

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private Set<Guestbook> guestbooks = new HashSet<>();

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<PostLikes> postLikes = new HashSet<>();

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", platformType=" + platformType +
                ", email='" + email + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", role='" + role + '\'' +
                ", isAuth=" + isAuth +
                '}';
    }
}