package hh.swd20.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class bookstoreController {
	
	@GetMapping("/index")
	public String sayHello() {
		return "bookstoreindex";

	}

}
