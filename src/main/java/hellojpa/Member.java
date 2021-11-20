package hellojpa;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.util.Date;

@Entity(name = "Member2")
@Data
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq", initialValue = 5, allocationSize = 1)
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long Id;

    @Column(name = "USERNAME")
    private String userName;

//    @Column(name="TEAM_ID")
//    private Long teamId;
    @ManyToOne()//fetch = 지연로딩
//    @JoinColumn(name = "TEAM_ID")
    private Team team;

//    private Integer age;
//
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob
//    private String description;

    public Member(){

    }
}
