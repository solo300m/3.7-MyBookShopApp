package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    public List<Book> getIdAuthorBook(Integer id){
        List<Book> books = jdbcTemplate.query("SELECT * FROM books WHERE id_author="+id+"",(ResultSet rs, int rowNum)->{
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setId_author(rs.getInt("id_author"));
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
    public List<Authors> getAuthorsList() {
        List<Authors> authors = jdbcTemplate.query("SELECT * FROM authors ", (ResultSet rs, int rowNum) -> {
            Authors auth = new Authors();
            auth.setId(rs.getInt("id"));
            auth.setAuthor(rs.getString("author"));
            return auth;
        });
        return new ArrayList<>(authors);
    }
    public Authors getAuthorId(Integer id){
        List<Authors>list = getAuthorsList();
        if(list.size() == 0) {
            setAuthorsData(getBookData());
            list = getAuthorsList();
        }
        List<Authors>temp = list.stream().filter(w->w.getId()==id).collect(Collectors.toList());
        return (temp.get(0));
    }
    public TreeMap<String,List<Authors>> getMapAuthors(List<Authors> listA){
        Map<String,List<Authors>> treeMap = new TreeMap<>();
        treeMap = listA.stream()
                .sorted(Comparator.comparing(Authors::getAuthor))
                .collect(Collectors.groupingBy(authors -> authors.getAuthor().substring(0,1)));
        /*for(Map.Entry<String,List<Authors>> at: treeMap.entrySet()){
            Logger.getLogger(BookService.class.getName()).info(at.getKey());
            for(Authors authors: at.getValue()){
                Logger.getLogger(BookService.class.getName()).info(authors.getAuthor());
            }
        }*/
        return new TreeMap<>(treeMap);
    }
    public TreeMap<Integer,List<Authors>> getMapId(List<Authors> listA){
        Map<Integer,List<Authors>> treeMap = new TreeMap<>();
        treeMap = listA.stream()
                .sorted(Comparator.comparing(Authors::getAuthor))
                .collect(Collectors.groupingBy(authors -> authors.getId()));
        /*for(Map.Entry<String,List<Authors>> at: treeMap.entrySet()){
            Logger.getLogger(BookService.class.getName()).info(at.getKey());
            for(Authors authors: at.getValue()){
                Logger.getLogger(BookService.class.getName()).info(authors.getAuthor());
            }
        }*/
        return new TreeMap<>(treeMap);
    }
    public void setAuthorsData(List<Book> list){
        HashSet<String> auth = new HashSet<>();
        for(int i = 0; i<list.size();i++){
            auth.add(list.get(i).getAuthor());
        }
        //MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        List<Authors> test = jdbcTemplate.query("SELECT * FROM authors",(ResultSet rs, int rowNum)->{
            Authors aut = new Authors();
            aut.setId(rs.getInt("id"));
            aut.setAuthor(rs.getString("author"));
            return aut;
        });
        if(test.size()==0) {
            Iterator<String> s = auth.stream().iterator();
            for (Iterator<String> it = s; it.hasNext(); ) {
                Authors author = new Authors();
                String s1 = it.next();
                //parameterSource.addValue("aut",auth.get(i));
                jdbcTemplate.update("INSERT INTO authors(author,biography,photo) VALUES (?,?,?)", s1,author.getBiography(),author.getPhoto());
                Logger.getLogger(BookService.class.getName()).info("Updated author " + s1);
            }
        }
    }
    public void updateBookIdAuthors(){
        List<Authors>list = new ArrayList<>();
        list = jdbcTemplate.query("SELECT * FROM authors",(ResultSet rs, int rowNum)->{
            Authors authors = new Authors();
            authors.setId(rs.getInt("id"));
            authors.setAuthor(rs.getString("author"));
            authors.setBiography(rs.getString("biography"));
            authors.setPhoto(rs.getString("photo"));
            return authors;
        });
        for(Authors a: list){
            jdbcTemplate.update("UPDATE books SET id_author = ? WHERE author = ? AND id_author = 0",a.getId(),a.getAuthor());
        }
    }
}
