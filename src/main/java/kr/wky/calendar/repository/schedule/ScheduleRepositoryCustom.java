package kr.wky.calendar.repository.schedule;

import kr.wky.calendar.api.dto.MonthlyScheduleDto;

import java.util.List;

public interface ScheduleRepositoryCustom {
    List<MonthlyScheduleDto> findScheduleByMonth(String yearMonth);
}
