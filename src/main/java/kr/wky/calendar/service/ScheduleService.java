package kr.wky.calendar.service;

import kr.wky.calendar.api.dto.CreateScheduleDto;
import kr.wky.calendar.api.dto.MonthlyScheduleDto;
import kr.wky.calendar.api.dto.ScheduleDto;
import kr.wky.calendar.entity.Schedule;
import kr.wky.calendar.repository.schedule.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Optional<Schedule> findById(Long cId){
        return scheduleRepository.findById(cId);
    }

    public List<MonthlyScheduleDto> findMonthlySchedule(String yearMonth){
        return scheduleRepository.findScheduleByMonth(yearMonth);
    }

    @Transactional
    public Long saveSchedule(Schedule schedule){

        return scheduleRepository.save(schedule).getSId();
    }

    @Transactional
    public void deleteSchedule(Long cId){
        scheduleRepository.deleteById(cId);
    }

}
