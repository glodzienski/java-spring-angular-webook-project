package webbook.api.service;

import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import webbook.api.model.BookInfo;
import webbook.api.repository.BookInfoRepository;

@Service
public class BookInfoService implements ApiCrudServiceContract<BookInfo> {
    @Autowired
    private BookInfoRepository repository;

    @Contract(pure = true)
    public BookInfoService(BookInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookInfo store(BookInfo bookInfo) {
        return repository.save(bookInfo);
    }

    @Override
    public BookInfo update(BookInfo currentBookInfo, BookInfo requestBookInfo) {
        currentBookInfo.setDescription(requestBookInfo.getDescription());
        currentBookInfo.setSynopsis(requestBookInfo.getSynopsis());
        currentBookInfo.setReleaseDate(requestBookInfo.getReleaseDate());

        return currentBookInfo;
    }

    @Override
    public BookInfo getById(int id) {
        return null;
    }

    @Override
    public BookInfo getByCode(String code) {
        throw new ResponseStatusException(
                HttpStatus.METHOD_NOT_ALLOWED,
                "Não é possível buscar informações da obra pelo código. Coluna não existe."
        );
    }

    @Override
    public Iterable<BookInfo> list() {
        return repository.findAll();
    }

    @Override
    public void destroy(BookInfo bookInfo) {
        repository.delete(bookInfo);
    }

    public void validateSave (BookInfo bookInfo) {
        if (bookInfo.getDescription().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE,
                    "Por favor, preencha o campo description nas informações da obra."
            );
        }
        if (bookInfo.getReleaseDate() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE,
                    "Por favor, preencha o campo releaseDate nas informações da obra."
            );
        }
        if (bookInfo.getSynopsis().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE,
                    "Por favor, preencha o campo synopsis nas informações da obra."
            );
        }
    }
}
