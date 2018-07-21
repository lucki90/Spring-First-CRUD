package com.sda.spring.javaSpring1.controller;


import com.sda.spring.javaSpring1.model.Book;
import com.sda.spring.javaSpring1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books") // dzieki temu nie trzbea podawac sciezki do metody
public class BookController {


    @Autowired
    private BookService bookService;

    /**
     * Jest jedna metoda z GET dla endpointa(takie jest założenie resta)
     * Tego nie powinno być // mogloby nie być
     **/
    @GetMapping
// nie musze tutaj pistac sciezi @PostMapping(..), moge tez dac inna sciezke wtedy byłoby /books/innaSciezka
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAll() {
        return bookService.getBooks();
    }

    //szukanie po nazwie i cenie
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> search(@RequestParam(value = "name", defaultValue = "") String name,
                             @RequestParam(value = "minPrice", defaultValue = "0") Double minPrice,
                             @RequestParam(value = "maxxPrice", required = false) Double maxPrice) {

        return bookService.search(name, maxPrice, minPrice);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book newBook) {
        return bookService.add(newBook);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getById(@PathVariable("id") Long id) {
        return bookService.get(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book update(@PathVariable Long id,
                       @RequestBody Book book) {
        return bookService.update(id, book);

    }
}
