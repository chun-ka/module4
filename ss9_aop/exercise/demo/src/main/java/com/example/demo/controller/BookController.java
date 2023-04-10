package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BookCode;
import com.example.demo.service.IBookCodeService;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBookCodeService iBookCodeService;

    @GetMapping("")
    public String showList(@CookieValue(value = "counter", defaultValue = "0") Long counter, HttpServletResponse response, Model model) {
        counter++;
        Cookie cookie = new Cookie("counter", counter.toString());
        cookie.setMaxAge(30);
        response.addCookie(cookie);
        Iterable<Book> books = iBookService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("cookie", cookie);
        return "book/list";
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable int id, Model model) {
        Book book = iBookService.findById(id).get();
        model.addAttribute("book", book);
        return "book/borrow";
    }

    @PostMapping("/borrow")
    public String borrow(Book book, RedirectAttributes redirectAttributes) {
        if (book.getAmount() == 0) {
            redirectAttributes.addFlashAttribute("mess", "Số lượng tạm thời đang hết,vui lòng chọn sản phẩm khác");
            return "redirect:/book";
        }
        book.setAmount(book.getAmount() - 1);
        iBookService.save(book);
        int oderCode = (int) (Math.random() * (99999 - 10000)) + 10000;
        BookCode bookCode = new BookCode(oderCode, book, true);
        iBookCodeService.save(bookCode);
        redirectAttributes.addFlashAttribute("mess", "mượn thành công");
        redirectAttributes.addFlashAttribute("mess1", "bạn đã mượn cuốn: " + book.getBookName() + " ,mã mượn sách của bạn là " + oderCode + " .Hãy giữ lại mã này khi trả sách");
        return "redirect:/book";
    }

    @GetMapping("/pay/{id}")
    public String pay(@PathVariable int id, Model model) {
        Book book = iBookService.findById(id).get();
        model.addAttribute("book", book);
        return "book/pay";
    }

    @PostMapping("/pay")
    public String pay(Book book, RedirectAttributes redirectAttributes, int code, Model model) {
        try {
            BookCode bookCode = iBookCodeService.findById(code).get();
            if (bookCode.isFlag() && book.getId()==bookCode.getBook().getId()) {
                bookCode.setFlag(false);
                book.setAmount(book.getAmount() + 1);
                iBookService.save(book);
                iBookCodeService.save(bookCode);
                redirectAttributes.addFlashAttribute("mess", "trả thành công");
                redirectAttributes.addFlashAttribute("mess1", "cảm ơn bạn và hẹn gặp lại");
                return "redirect:/book";
            }
        } catch (Exception e) {
            System.out.println("mã trả sách không hợp lệ");
        }
        model.addAttribute("book", book);
        model.addAttribute("mess", "mã không đúng,xin nhập lại");
        return "book/pay";
    }

}
