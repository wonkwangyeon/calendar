package kr.wky.calendar.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue
    @Column(name = "s_id")
    private Long sId;

    private String content;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    private Boolean isAllDay;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cate_code")
    private Category cateCode;

    public Schedule(String content, LocalDateTime startDate, LocalDateTime endDate, User userId, Boolean isAllDay, Category cateCode) {
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
        this.isAllDay = isAllDay;
        this.cateCode = cateCode;
    }
}
