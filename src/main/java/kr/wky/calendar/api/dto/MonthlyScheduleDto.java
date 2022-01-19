package kr.wky.calendar.api.dto;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class MonthlyScheduleDto {
    private Long sId;
    private String content;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean isAllDay;

    private String userId;
    private String userName;

    private Long cateCode;
    private String cateName;

    @QueryProjection
    public MonthlyScheduleDto(Long sId, String content, LocalDateTime startDate, LocalDateTime endDate, Boolean isAllDay, String userId, String userName, Long cateCode, String cateName) {
        this.sId = sId;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isAllDay = isAllDay;
        this.userId = userId;
        this.userName = userName;
        this.cateCode = cateCode;
        this.cateName = cateName;
    }
}
