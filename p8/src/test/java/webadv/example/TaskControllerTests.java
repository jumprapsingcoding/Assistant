package webadv.example;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTests {
	@Autowired
	private MockMvc mockMvc;	//mockito,spring-test
	@Test
	public void test() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/task/1"))
        .andExpect(MockMvcResultMatchers.status().isOk()) 
		.andExpect(jsonPath("$.content", containsString("Java EE"))) //jsonpath
        .andReturn();		
	/*
ObjectMapper mapper = new ObjectMapper(); //jackson
String jsonstr = result.getResponse().getContentAsString();
		Task task = mapper.readValue(jsonstr, Task.class);
		assertNotNull(task); 
*/
		//assertTrue(task.getContent().contains("Java EE") && task.getId()==1); 
	}
}