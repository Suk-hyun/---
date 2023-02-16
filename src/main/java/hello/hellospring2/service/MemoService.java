package hello.hellospring2.service;

import hello.hellospring2.domain.Memo;
import hello.hellospring2.repository.MemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Long save(Memo memo) {
        memoRepository.save(memo);
        return memo.getId();
    }

    public List<Memo> findMemos() {
        return memoRepository.findAll();
    }

    public Optional<Memo> findOne(String title) {
        return memoRepository.findByTitle(title);
    }
}
