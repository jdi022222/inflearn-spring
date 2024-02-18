package site.comibird.aop.exam;

import org.springframework.stereotype.Repository;

import site.comibird.aop.exam.annotation.Trace;

@Repository
public class ExamRepository {

	private static int seq = 0;

	/**
	 * 성공률 20퍼
	 */
	@Trace
	public String save(String itemId) {
		seq++;
		if (seq % 5 == 0) {
			throw new IllegalArgumentException("예외 발생");
		}
		return "ok";
	}
}
