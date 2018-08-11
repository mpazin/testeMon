package com.monsanto.interview.FortuneCookieGenerator;



import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.CorsFilter;


import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(FortuneCookieController.class)
public class FortuneCookieTest  {
	
	@Autowired
    private MockMvc mockMvc;
	
	
	
	@InjectMocks
    private FortuneCookieController FortuneCookieController;
	
	@InjectMocks
	private QuoteRepository quoteRepository;

	@InjectMocks
	private FortuneCookieBuilder fortuneCookieBuilder;
	
	@Test
	public void generateFortuneCookieTest() throws Exception {
		
		ArrayList<String> names = new ArrayList<String>() {{
		    add("Jane");
		    add("Jhon");
		    add("Michelle");
		}};
		
		ArrayList<String> commerces = new ArrayList<String>() {{
		    add("Store");
		    add("Supermarket");
		    add("Library");
		}};
		
		Random r = new Random();
		String name = names.get(r.nextInt(names.size()));
		String commerce = commerces.get(r.nextInt(commerces.size()));
		
		 mockMvc.perform(get("/generateFortuneCookie").
				 param("client", name).
				 param("company", commerce)).
		 		 andExpect(status().isOk());  

	}

	

	

}
