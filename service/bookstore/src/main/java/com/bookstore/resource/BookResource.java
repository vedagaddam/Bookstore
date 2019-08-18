package com.bookstore.resource;

import com.bookstore.domain.Book;
import com.bookstore.service.BookService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookResource {
    private final BookService bookService;
    @Autowired
    public BookResource(BookService bookService){
        this.bookService=bookService;
    }
    @PostMapping(value="/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody  Book book)
    {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @PostMapping(value = "/id/{id}/image")
    public ResponseEntity addImage(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        String fileName = multipartHttpServletRequest.getFileNames().next();
        MultipartFile multipartFile = multipartHttpServletRequest.getFile(fileName);
        byte[] imageData = multipartFile.getBytes();
        String savingImage = id + ".png";
        FileOutputStream outputStream = new FileOutputStream(new File("src/main/resources/" + savingImage));
        outputStream.write(imageData);
        outputStream.close();
        return ResponseEntity.ok("uploaded successfully");
    }
    @GetMapping("/bookList")
    public ResponseEntity findAllBooks()

    {
      List<Book> books=  bookService.findAllBooks();

      return ResponseEntity.ok(books);

    }
    @GetMapping("id/{id}")
    public ResponseEntity fetchBookById(@PathVariable("id") Long id){
       Book book= bookService.fetchBookById(id);
       return ResponseEntity.ok(book);
    }
}
