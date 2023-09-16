package com.onlinesales;

import com.onlinesales.controller.MathController;
import com.onlinesales.service.WolframAlphaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class MathapiApplicationTests {

	private MockMvc mockMvc;

	@InjectMocks
	private MathController mathController;

	@Mock
	private WolframAlphaService wolframAlphaService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
	}

	@Test
	public void testEvaluateExpression() throws Exception {
		String expression = "2+2";
		String expectedResult = "4";

		when(wolframAlphaService.evaluateExpression(expression)).thenReturn(expectedResult);

		mockMvc.perform(MockMvcRequestBuilders.post("/evaluate")
						.contentType(MediaType.TEXT_PLAIN)
						.content(expression))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("2+2 => 4"));
	}
}

