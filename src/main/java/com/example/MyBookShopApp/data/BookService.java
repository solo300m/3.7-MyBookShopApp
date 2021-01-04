package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBookData() {
       List<Book> books = jdbcTemplate.query("SELECT * FROM books",(ResultSet rs, int rowNum)->{
           Book book = new Book();
           book.setId(rs.getInt("id"));
           book.setAuthor(rs.getString("author"));
           book.setTitle(rs.getString("title"));
           book.setPriceOld(rs.getString("priceOld"));
           book.setPrice(rs.getString("price"));
           return book;
       });
       return new ArrayList<>(books);
    }
    public List<Authors> getAuthorsData(char a) {
        List<Authors> authors = jdbcTemplate.query("SELECT * FROM authors WHERE author LIKE '"+a+"%'", (ResultSet rs, int rowNum) -> {
            Authors auth = new Authors();
            auth.setId(rs.getInt("id"));
            auth.setAuthor(rs.getString("author"));
            return auth;
        });
        if(authors.size()!=0)
            return new ArrayList<>(authors);
        else{
            authors.add(new Authors("нет данных"));
            return new ArrayList<>(authors);
        }
    }
    public void setAuthorsData(List<Book> list){
        HashMap<Integer,String> auth = new HashMap<>();
        for(int i = 0; i<list.size();i++){
            auth.put(i,list.get(i).getAuthor());
        }
        //MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        for(int i = 0; i<auth.size();i++){
            //parameterSource.addValue("aut",auth.get(i));
            jdbcTemplate.update("INSERT INTO authors(author) VALUES (?)",auth.get(i));
            Logger.getLogger(BookService.class.getName()).info("Updated author "+ auth.get(i));
        }
    }
}
