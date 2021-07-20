/*
package com.kaung.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller层调service层
    @Autowired
    @Qualifier("bookServiceImpl")
    private com.kaung.service.bookService bookService ;

    //查询全部的书籍，并且返回一个书籍返回页面
    @RequestMapping(value = "/allBook", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String list() throws JsonProcessingException {

        List<books> list = bookService.queryAllBooks();

        return "{ \"code\":200,\"message\":\"成功\",\"data\":" + JSONObject.toJSONString(list) + ",\"count\" : \"10\"}";
    }

    //跳转到书籍增加页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){

        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(books books){
        System.out.println("addbook"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";  //重定向
    }
    //跳转到书籍更新页面Update
    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(int id,Model model){
        books books = bookService.queryBookById(id);
        model.addAttribute("QBook",books);
        return "updateBook";
    }
    @RequestMapping("updateBook")
    public String updateBook(books books){
        System.out.println("修改了"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
    @RequestMapping("deleteBook")
    public String deleteBook( int id){

        int i = bookService.deleteBookById(id);
        System.out.println(i);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        books books = bookService.queryBookByName(queryBookName);
        List<books> list = new ArrayList<>();
        list.add(books);
        if(books==null){
            list = bookService.queryAllBooks();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list",list);
        return "allBook";
    }


}
*/
