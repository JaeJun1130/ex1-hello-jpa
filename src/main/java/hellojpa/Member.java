package hellojpa;

import javax.persistence.*;
import java.math.BigDecimal;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 10, columnDefinition = "varchar(10) default 'EMPTY'")
    private String username;

    private Integer age;

    @Column(columnDefinition = "DECIMAL(13,2)")
    BigDecimal sourceAmt;       // 송금액

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
}