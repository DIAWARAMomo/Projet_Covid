package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class NavBean {

	public String goHome() {
		
		return "index";
	}
	
	public String goResult() {
		
		return "result";
	}
}
