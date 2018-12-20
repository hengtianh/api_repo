package org.easy.develop.web;

import org.easy.develop.web.controller.ApiController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ApiControllerTest {

	@Test
	public void testHome() throws Exception {
		ApiController apiController = new ApiController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(apiController).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("home"));
	}
}
