package presenter;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/initDB")
public class InitDBPresenter {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String createTestData() {
		
		String msg = null;
		
		try {
			//InitDBSpring.createTestData();
			msg = "DB riempito";
		} catch (Exception e) {
			msg = "Si è verificato un errore";
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return msg;
		
	}
	
	
}
