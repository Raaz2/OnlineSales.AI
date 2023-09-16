package com.onlinesales;

import com.onlinesales.service.WolframAlphaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class WolframAlphaServiceTest {

    @InjectMocks
    private WolframAlphaService wolframAlphaService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        wolframAlphaService = new WolframAlphaService(new RestTemplateBuilder().build());
    }

    @Test
    public void testEvaluateExpression() {
        String expression = "2+2";
        String expectedResult = "4";

        String apiUrl = wolframAlphaService.getBaseUrl() + "?appid=" + wolframAlphaService.getAppid() +  "&i=" + expression;;

        when(restTemplate.getForObject(apiUrl, String.class)).thenReturn(expectedResult);

        String result = wolframAlphaService.evaluateExpression(expression);
        assert(result.equals(expectedResult));
    }
}

