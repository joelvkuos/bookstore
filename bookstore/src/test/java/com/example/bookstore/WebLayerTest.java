package com.example.bookstore;

import static org.mockito.ArgumentMatchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.CategoryRepository;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    public void testDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/booklist")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Books")));
    }
}
