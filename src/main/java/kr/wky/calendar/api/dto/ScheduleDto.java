package kr.wky.calendar.api.dto;

import kr.wky.calendar.entity.Category;
import kr.wky.calendar.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {

    private String content;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private String userName;

    private Boolean isAllDay;
    private String cateName;

}
