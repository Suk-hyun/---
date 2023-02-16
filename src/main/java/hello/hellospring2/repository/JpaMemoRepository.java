package hello.hellospring2.repository;

import hello.hellospring2.domain.Member;
import hello.hellospring2.domain.Memo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemoRepository implements MemoRepository{

    private final EntityManager em;

    public JpaMemoRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Memo save(Memo memo) {
        em.persist(memo);
        return memo;
    }

    @Override
    public Optional<Memo> findByTitle(String title) {
        List<Memo> result = em.createQuery("select m from Memo m where m.title = :title",
                        Memo.class)
                .setParameter("title", title)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Memo> findAll() {
        return em.createQuery("select m from Memo m", Memo.class)
                .getResultList();
    }
}
