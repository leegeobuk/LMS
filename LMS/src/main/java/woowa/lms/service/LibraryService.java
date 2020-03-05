package woowa.lms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import woowa.lms.repository.AccountRepository;
import woowa.lms.repository.ItemRepository;
import woowa.lms.repository.LibraryRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LibraryService {

//    private final LibraryRepository;
//    private final AccountRepository;
//    private final ItemRepository;

}
