package com.anand.restContoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.anand.binding.Quotes;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class QuotesController {

	
	@GetMapping("/pg")
	public String welcomePage() {
		System.out.println("inside Welcome Page Method");
		return "index";
	}

	@ResponseBody
	public List<Quotes> getFromurl(){
		System.out.println("inside URL Method");
		String url="https://dummyjson.com/quotes";
		//rest Template Object is Created
		RestTemplate template=new RestTemplate();
		//Object Mapper
		ObjectMapper mapper=new ObjectMapper();
		List<Quotes> lq=new ArrayList<>();	
		try {
		ResponseEntity<String> resEntity=template.getForEntity(url,String.class);
		String jsonResponse=resEntity.getBody();
		//parse Json Object
		JsonNode rootNode=mapper.readTree(jsonResponse);
		JsonNode quotesArrayNode=rootNode.get("quotes");
		if(quotesArrayNode!=null && quotesArrayNode.isArray()) {
			for(JsonNode quoteNode:quotesArrayNode) {
		Quotes quotesObject=mapper.treeToValue(quoteNode,Quotes.class);
		    lq.add(quotesObject);
			}
			return lq;
		}else {
			System.out.println("Error Quotes array Not Found");
		}
		}catch (Exception e) {
           e.printStackTrace();
		}
	    return null;
	}
	
	@GetMapping("/quotes")
	public String getQuotes(Model model){
		System.out.println("inside Get Quotes Method");
		//get List Of Object first
		List<Quotes> finalResult=getFromurl();
		model.addAttribute("quots", finalResult);
		return "quotes";
	}
	
}
