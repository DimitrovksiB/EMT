package finki.emt.emt.web;

import finki.emt.emt.model.Author;
import finki.emt.emt.model.Books;
import finki.emt.emt.model.enumerations.BookCategory;
import finki.emt.emt.service.AuthorService;
import finki.emt.emt.service.BooksService;
import finki.emt.emt.service.CountryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BooksController {
    private final BooksService booksService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public BooksController(BooksService booksService, AuthorService authorService, CountryService countryService) {
        this.booksService = booksService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @GetMapping({"/","/books"})
    public String showList(Model model)
    {
        List<Books> books = this.booksService.listAll();
        model.addAttribute("books",books);
        return "ListBooks";
    }
    @GetMapping("/books/add")
    public String showAdd(Model model)
    {
        model.addAttribute("authors",authorService.listAll());
        model.addAttribute("category", BookCategory.values());
        return "form";
    }
    @GetMapping("/books/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model)
    {
        Books books = booksService.findById(id);

        model.addAttribute("books",books);
        model.addAttribute("author",authorService.listAll());
        model.addAttribute("category",BookCategory.values());
        return "form";
    }
    @PostMapping("/books")
    public String create(@RequestParam String name,
                         @RequestParam Integer copies,
                         @RequestParam BookCategory category,
                         @RequestParam Long authorId
                         ) {

        this.booksService.Create(name,category,authorId,copies);
        return "redirect:/employees";
    }
    @PostMapping("/books/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam Integer copies,
                         @RequestParam BookCategory category,
                         @RequestParam Long authorId) {
        this.booksService.Update(id,name,category,authorId,copies);
        return "redirect:/books";
    }
    @PostMapping("/books/{id}/delete")
    public String delete(@PathVariable Long id) {
        this.booksService.Delete(id);
        return "redirect:/books";
    }

}
