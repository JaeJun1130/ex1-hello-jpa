package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {
    @Id
    private Long id;
    /**
     * updatable 절때 업데이트 되지않음 JPA 어플리케이션에서는
     * nullable not null 제약조건이 걸림
     * unique 유니크 제약조건 (이름이 랜덤으로 생성되기 때문에 Table 단계에서 제약조건을 걸음)
     * columnDefinition 데이터베이스 컬럼 정보를 직접 줄 수 있다. ex) varchar(100) default ‘EMPTY'
     */
    @Column(name = "name", updatable = false, nullable = false, unique = true,columnDefinition = "")
    private String username;

    private Integer age;

    /**
     * 디폴트가 순서로 저장됨
     * 순서로 저장하면 enum 순서가 바뀌면 문제가 발생 EnumType.STRING 으로 사용하는걸 권장 (value 값으로 저장됨)
     */
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    /**
     * 최신버전에는 Temporal 를 안써도 LocalDateTime, LocalDate 를 사용하면 JPA 에서 인색해서 사용해줌
     */
    private LocalDateTime localDateTime1;
    private LocalDate localDate2;

    @Lob
    private String description;

    @Transient
    private int temp;
}