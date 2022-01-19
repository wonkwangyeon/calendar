package kr.wky.calendar.repository.schedule;

import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.wky.calendar.api.dto.MonthlyScheduleDto;
import kr.wky.calendar.api.dto.QMonthlyScheduleDto;
import kr.wky.calendar.entity.QCategory;
import kr.wky.calendar.entity.QSchedule;
import kr.wky.calendar.entity.QUser;

import javax.persistence.EntityManager;
import java.util.List;

import static kr.wky.calendar.entity.QCategory.category;
import static kr.wky.calendar.entity.QSchedule.schedule;
import static kr.wky.calendar.entity.QUser.user;
import static org.springframework.util.StringUtils.hasText;


public class ScheduleRepositoryImpl implements ScheduleRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    public ScheduleRepositoryImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<MonthlyScheduleDto> findScheduleByMonth(String yearMonth) {
        StringTemplate startDate = Expressions.stringTemplate(
                "DATE_FORMAT({0}, {1})"
                , schedule.startDate
                , ConstantImpl.create("%Y-%m"));

        StringTemplate endDate = Expressions.stringTemplate(
                "DATE_FORMAT({0}, {1})"
                , schedule.endDate
                , ConstantImpl.create("%Y-%m"));

        return queryFactory
                .select(new QMonthlyScheduleDto(schedule.sId, schedule.content,
                        schedule.startDate, schedule.endDate, schedule.isAllDay,
                        user.userId, user.userName, category.cateCode, category.cateName))
                .from(schedule)
                .innerJoin(schedule.userId, user)
                .innerJoin(schedule.cateCode, category)
                .where(startDate.loe(yearMonth)
                        .and(endDate.goe(yearMonth))
                ).fetch();

    }

}
