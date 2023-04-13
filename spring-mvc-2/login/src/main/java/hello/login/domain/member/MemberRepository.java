package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Repository
public class MemberRepository {

    private static ConcurrentHashMap<Long, Member> store = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong(0);

    public Member save(Member member) {
        member.setId(sequence.getAndIncrement());
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        return Optional.of(store.get(id));
    }

    public Optional<Member> findByLoginId(String loginId) {
/*        List<Member> all = findAll();
        for (Member m : all) {
            if (m.getId().equals(loginId)) {
                return Optional.of(m);
            }
        }
        return Optional.empty();*/

        return findAll().stream()
                .filter(m -> m.getId().equals(loginId))
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
