package tw.group4._35_.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

@RestController
public class ValidateCaptcha {
	
	@Value("https://www.google.com/recaptcha/api/siteverify")
	private String validateApi;
	
	@Value("6Lc_wOQZAAAAACsoC6R-Gu2UwC36X9hOwwooQlbE")
	private String captchaServerSecret;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/35/validate")
	public ResponseEntity<JSONObject> validateCaptcha (HttpServletRequest request,
						@RequestParam("token")String token) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);

		MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
		requestBody.add("secret", this.captchaServerSecret);
		requestBody.add("response", token);
		requestBody.add("remoteip", request.getRemoteAddr()); // 客戶的ip位置，非必要參數
		
		ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(this.validateApi, new HttpEntity<>(requestBody, httpHeaders), JSONObject.class);
		
		if (!responseEntity.getStatusCode().is2xxSuccessful()) {
			// 異常的HTTP狀態碼
			System.out.println("異常HTTP狀態碼，非2xx");
		}
		
//		在js回傳後設定，如果是真人才顯示登入按鈕
		System.out.println(responseEntity.getBody());
		
		return responseEntity; //研究responseEntity和responseEntity.getBody()
	}
}
