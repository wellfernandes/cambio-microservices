package br.com.wellitonleal.bookservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Book implements Serializable {

    private Long id;
    private String author;
    private String title;
    private Date launchDate;
    private Double price;

    private String currency;
    private String environment;

    public Book() {
    }

    public Book(Long id, String author, String title, Date launchDate, Double price, String currency, String environment) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.launchDate = launchDate;
        this.price = price;
        this.currency = currency;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getEnvironment() {
        return environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!Objects.equals(id, book.id)) return false;
        if (!Objects.equals(author, book.author)) return false;
        if (!Objects.equals(title, book.title)) return false;
        if (!Objects.equals(launchDate, book.launchDate)) return false;
        if (!Objects.equals(price, book.price)) return false;
        if (!Objects.equals(currency, book.currency)) return false;
        return Objects.equals(environment, book.environment);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (launchDate != null ? launchDate.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (environment != null ? environment.hashCode() : 0);
        return result;
    }
}
