package webbook.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webbook.api.entity.BookInfo;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfo, String> {
}
