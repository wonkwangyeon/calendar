package kr.wky.calendar.api.v1;

import kr.wky.calendar.api.dto.ApiResult;
import kr.wky.calendar.api.dto.CreateScheduleDto;
import kr.wky.calendar.api.dto.ScheduleDto;
import kr.wky.calendar.entity.Category;
import kr.wky.calendar.entity.Schedule;
import kr.wky.calendar.entity.User;
import kr.wky.calendar.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController("/api/v1/schedule")
@RequiredArgsConstructor
public class ScheduleApiController {

    private final ScheduleService scheduleService;

    @GetMapping("/monthly")
    public ApiResult getMonthlySchedule(@RequestParam(value = "yearMonth", defaultValue = "0") String yearMonth) {
        if ("0".equals(yearMonth)) {
            LocalDate now = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
            String formatedNow = now.format(formatter);
            yearMonth = formatedNow;
        }
        return new ApiResult(scheduleService.findMonthlySchedule(yearMonth));
    }

    @GetMapping("/{cId}")
    public ApiResult getSchedule(@PathVariable("cId") Optional<Long> cId){

        List<ScheduleDto> scheduleDto = scheduleService.findById(cId.orElseThrow(()-> new NoSuchElementException()))
                .stream().map(m -> new ScheduleDto(m.getContent(),
                        m.getStartDate(), m.getEndDate(), m.getUserId().getUserName(),
                        m.getIsAllDay(), m.getCateCode().getCateName())).collect(Collectors.toList());

        return new ApiResult(scheduleDto);
    }

    @PostMapping("")
    public ApiResult createSchedule(@RequestBody @Valid CreateScheduleDto createScheduleDto){

        Schedule schedule = new Schedule(createScheduleDto.getContent()
                ,createScheduleDto.getStartDate()
                ,createScheduleDto.getEndDate()
                ,new User(createScheduleDto.getUserId())
                ,createScheduleDto.getIsAllDay()
                ,new Category(createScheduleDto.getCateCode()));

        Long id = scheduleService.saveSchedule(schedule);
        return new ApiResult(id);
    }

    @PutMapping("/{cId}")
    public ApiResult updateSchedule(@PathVariable("cId") Optional<Long> cId, @RequestBody @Valid CreateScheduleDto createScheduleDto){

        Schedule schedule = new Schedule(
                cId.orElseThrow(()-> new NoSuchElementException())
                ,createScheduleDto.getContent()
                ,createScheduleDto.getStartDate()
                ,createScheduleDto.getEndDate()
                ,new User(createScheduleDto.getUserId())
                ,createScheduleDto.getIsAllDay()
                ,new Category(createScheduleDto.getCateCode()));

        Long id = scheduleService.saveSchedule(schedule);
        return new ApiResult(id);
    }

    @DeleteMapping("/{cId}")
    public ApiResult updateSchedule(@PathVariable("cId") Optional<Long> cId){

        scheduleService.deleteSchedule(cId.orElseThrow(()-> new NoSuchElementException()));
        return new ApiResult(1);
    }
}




















