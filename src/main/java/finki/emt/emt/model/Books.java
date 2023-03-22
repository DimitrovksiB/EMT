package finki.emt.emt.model;


import finki.emt.emt.model.enumerations.BookCategory;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BookCategory category;
    @ManyToOne
    private Author author;
    private Integer availableCopies;

    public Books(String name, BookCategory category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Books() {

    }
}
