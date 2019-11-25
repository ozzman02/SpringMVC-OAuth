package lab.spring.io.web.test;

import lab.spring.io.config.AdminWebContextConfig;
import lab.spring.io.config.RootContextConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AdminWebContextConfig.class, RootContextConfig.class})
@WebAppConfiguration
public class AdminControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Test
    public void testAdminContext() throws UnsupportedEncodingException, Exception {
        String expected = "Welcome Admin";
        String actual = mockMvc.perform(MockMvcRequestBuilders.get("/")).andReturn().getResponse().getContentAsString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWelcomeURI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/welcome/1"))
                .andExpect(MockMvcResultMatchers.view().name("welcome"))
                .andExpect(MockMvcResultMatchers.model().attribute("name", "INAM"));
    }

}
