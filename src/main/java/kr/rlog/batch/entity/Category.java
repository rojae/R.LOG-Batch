package kr.rlog.batch.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "TBL_CATEGORY")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private Long parentId;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Post> posts = new HashSet<Post>();


}
