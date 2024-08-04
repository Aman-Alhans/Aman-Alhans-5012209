package com.library.LibraryManagementNew;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        BookService bookService = context.getBean(BookService.class);
        bookService.doSomething();
        
        
        
    }
}
