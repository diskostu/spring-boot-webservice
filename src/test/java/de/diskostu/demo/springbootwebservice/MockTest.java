package de.diskostu.demo.springbootwebservice;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MockTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shoudlReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/greeting"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(CoreMatchers.containsStringIgnoringCase("world")));
    }


    @Test
    public void shoudlFail() throws Exception {
        this.mockMvc.perform(get("/greeting?name=devil"))
                    .andDo(print())
                    .andExpect(status().isForbidden());
    }
}