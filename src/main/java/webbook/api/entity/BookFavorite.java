package webbook.api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_book_favorite")
public class BookFavorite {
    @NotNull
    @Id
    @Column(nullable = false, unique = true)
    private String code;
}
