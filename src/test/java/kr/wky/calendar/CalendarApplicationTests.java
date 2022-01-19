package kr.wky.calendar;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.wky.calendar.entity.QUser;
import kr.wky.calendar.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CalendarApplicationTests {

	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {

//		User user = new User("test");
//		em.persist(user);
//
//		JPAQueryFactory query = new JPAQueryFactory(em);
//		QUser qUser = new QUser("test");
//
//		User result = query
//				.selectFrom(qUser)
//				.fetchOne();
//
//		assertThat(result).isEqualTo(user);
	}

}
