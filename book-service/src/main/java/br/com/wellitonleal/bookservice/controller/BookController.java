package br.com.wellitonleal.bookservice.controller;

import br.com.wellitonleal.bookservice.model.Book;
import br.com.wellitonleal.bookservice.proxy.CambioProxy;
import br.com.wellitonleal.bookservice.repository.BookRepository;
import br.com.wellitonleal.bookservice.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProxy cambioProxy;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBookById(@PathVariable("id") Long id, @PathVariable("currency") String currency) {

        var book = bookRepository.getReferenceById(id);
        if(book == null) throw new RuntimeException("Book not found");

        var cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(port + " FEING");

        assert cambio != null;
        book.setPrice(cambio.getConvertedValue());
        return book;
    }
}