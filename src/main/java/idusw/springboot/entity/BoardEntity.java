package idusw.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // 엔티티 클래스임으로 나타내는 애노테이션
@Table(name = "ab_board")

@ToString   // lombok 라이브러리 사용
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// JPA Auditing 활용한 생성한 사람, 생성일자, 수정한 사람, 수정일자 등을 선택해 감시
public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ab_board_seq_gen")
    @SequenceGenerator(sequenceName = "ab_board_seq",name="ab_board_seq_gen",initialValue = 1,allocationSize = 1)
    private Long bno;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 1000, nullable = false)
    private String content;

    @ManyToOne
    //@JoinColumn(name="seq")
    private MemberEntity writer;

}
