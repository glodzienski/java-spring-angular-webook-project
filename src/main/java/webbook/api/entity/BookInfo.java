package webbook.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_book_info")
public class BookInfo {
    @NotNull
    @Column(nullable = false, unique = true)
    private String code;

    @NotNull
    @Column(nullable = false)
    private String description;

    @NotNull
    @Column(nullable = false)
    private String synopsis;

    @NotNull
    @Column(name = "release_date", nullable = false)
    private String releaseDate;
}
