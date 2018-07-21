package com.sda.spring.javaSpring1.service;

import com.sda.spring.javaSpring1.exception.NotFoundException;
import com.sda.spring.javaSpring1.exception.ValidationException;
import com.sda.spring.javaSpring1.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();


    public List<Book> getBooks() {
        return books;
    }

    public List<Book> search(String name, Double maxPrice, Double minPrice){
       return books.stream()
                .filter(book -> book.getName().contains(name.toLowerCase()) &&
                        book.getPrice() > minPrice &&
                        book.getPrice() < (maxPrice == null ? Double.MAX_VALUE : maxPrice))
                .collect(Collectors.toList());
    }

    public Book add(Book newBook){
        if (newBook.getId()==null){
            throw new ValidationException("Id cannot be null");
        }
        books.add(newBook);
        return newBook;
    }

    //
    public Book get(Long id){
        Optional <Book> foundBook= books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
        if (foundBook.isPresent()){
            return foundBook.get();
        }else {
            throw  new NotFoundException("Book was not found");
        }
    }

    public void delete (Long id){
        Book bookToDelete = books.stream()
                .filter(book -> id.equals(book.getId()))
                .findFirst()
                .get();
        if (bookToDelete != null) {
            books.remove(bookToDelete);
        }
    }

    public Book update (Long id, Book book){
        Optional<Book> bookToUpdate = books.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
        if (bookToUpdate.isPresent()) {
            books.remove(bookToUpdate.get());
            book.setId(id);
            books.add(book);
            return book;
        } else {
            throw new RuntimeException(String.format("Book with id %s not found", id));
        }
    }

}
