package hello.login.web.session;

import hello.login.domain.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.Assertions.*;

class SessionManagerTest {

    SessionManager sessionManager = new SessionManager();

    @Test
    @DisplayName("세션 생성 테스트")
    void sessionTest() {
        //given

        //세션 생성
        MockHttpServletResponse response = new MockHttpServletResponse();
        Member member = new Member();
        sessionManager.createSession(member, response);

        //요청에 응답 쿠키 저장
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        //when
        Object result = sessionManager.getSession(request);

        //then
        assertThat(result).isEqualTo(member);
    }

    @Test
    @DisplayName("세션 만료 테스트")
    void sessionExpireTest() {
        //given

        //세션 생성
        MockHttpServletResponse response = new MockHttpServletResponse();
        Member member = new Member();
        sessionManager.createSession(member, response);

        //요청에 응답 쿠키 저장
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        //when
        sessionManager.expire(request);
        Object expired = sessionManager.getSession(request);

        //then
        assertThat(expired).isNull();
    }

}