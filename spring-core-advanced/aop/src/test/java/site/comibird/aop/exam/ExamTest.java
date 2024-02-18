package site.comibird.aop.exam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import site.comibird.aop.exam.aop.TraceAspect;

@SpringBootTest
@Import(TraceAspect.class)
public class ExamTest {

	@Autowired
	ExamService examService;

	@Test
	void test() {
		for (int i = 0; i < 5; i++) {
			examService.request("data" + i);
		}
	}
}
