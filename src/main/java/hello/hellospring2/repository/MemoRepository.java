package hello.hellospring2.repository;

import hello.hellospring2.domain.Memo;

import java.util.List;
import java.util.Optional;

public interface MemoRepository {

    Memo save(Memo memo);

    Optional<Memo> findByTitle(String title);

    List<Memo> findAll();
}
