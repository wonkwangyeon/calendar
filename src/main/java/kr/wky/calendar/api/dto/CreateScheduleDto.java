package kr.wky.calendar.api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateScheduleDto {

    private String content;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private String userId;

    private Boolean isAllDay;

    private Long cateCode;
}
