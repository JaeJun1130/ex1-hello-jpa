package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

//@Entity
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 1,
        allocationSize = 2)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR")
    /**
     * IDENTITY 전략은 쿼리가 인서트 시점에 PK가 DB에 인서트가 되므로 영속성 컨테이너에 PK값을 알 수가 없다. 그래서
     * commit 시점이 아닌 persist 를 호출한 시점에 인서트를 날려버린다.
     * 그래서 모와서 인서트하는 전략을 IDENTITY 애서는 사용할 수 없다.
     */
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * sequence 테이블에서 next value 를 통해 값을 가져온다
     * 그러면 네트워크를 계속 타기때문에 성능상 문제가 생길 수 있다
     * 그걸 해결하기 위해 allocationSize 를 통해 한번에 시퀀스를 땡겨올 수 있다.
     */
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)

//    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    /**
     * updatable 절때 업데이트 되지않음 JPA 어플리케이션에서는
     * nullable not null 제약조건이 걸림
     * unique 유니크 제약조건 (이름이 랜덤으로 생성되기 때문에 Table 단계에서 제약조건을 걸음)
     * columnDefinition 데이터베이스 컬럼 정보를 직접 줄 수 있다. ex) varchar(100) default ‘EMPTY'
     */
//    @Column(name = "name", updatable = false, nullable = false, unique = true,columnDefinition = "")
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
     * 최신버전에는 Temporal 를 안써도 LocalDateTime, LocalDate 를 사용하면 JPA 에서 인색해서 사용해
     */
    private LocalDateTime localDateTime1;
    private LocalDate localDate2;

    @Lob
    private String description;

    @Transient
    private int temp;

    protected Member() {
    }

    private Member(Long id, String username, Integer age, RoleType roleType, Date createdDate, Date lastModifiedDate, LocalDateTime localDateTime1, LocalDate localDate2, String description, int temp) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.roleType = roleType;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.localDateTime1 = localDateTime1;
        this.localDate2 = localDate2;
        this.description = description;
        this.temp = temp;
    }

    public Member(String username, int age, RoleType roleType) {
        this.username = username;
        this.age = age;
        this.roleType = roleType;
    }

    public static Member createMember(String username, int age, RoleType roleType) {
        return new Member(username,age,roleType);
    }


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public LocalDateTime getLocalDateTime1() {
        return localDateTime1;
    }

    public LocalDate getLocalDate2() {
        return localDate2;
    }

    public String getDescription() {
        return description;
    }

    public int getTemp() {
        return temp;
    }
}