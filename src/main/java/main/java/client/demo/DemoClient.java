package main.java.client.demo;

import java.util.Arrays;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
//https://attacomsian.com/blog/http-requests-resttemplate-spring-boot
public class DemoClient {


	final static String ROOT_URI = "https://jsonplaceholder.typicode.com/posts/{id}";
	
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		Post post = restTemplate.getForObject(ROOT_URI, Post.class,1);
				
				
		System.out.println("Response is " + post);
		System.out.println("*******************");
		
		ResponseEntity<Post> post2 = restTemplate.getForEntity(ROOT_URI, Post.class,1);
		
		System.out.println(post2.getBody().getId());
		System.out.println(post2.getBody().getUserId());
		System.out.println(post2.getBody().getTitle());
		System.out.println(post2.getBody().getBody());
		System.out.println("post2.getStatusCodeValue()"+post2.getStatusCodeValue()); 
		System.out.println("post2.getStatusCode()"+post2.getStatusCode());
		System.out.println("post2.getHeaders()"+post2.getHeaders());
		
//		 if(response.getStatusCode() == HttpStatus.OK) {
//		        return response.getBody();
//		    } else {
//		        return null;
//		    }
		
		
	   

	}
	
	
	

}
