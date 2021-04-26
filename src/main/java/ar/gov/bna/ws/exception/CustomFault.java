package ar.gov.bna.ws.exception;

import javax.xml.ws.WebFault;

@WebFault(name = "CustomFault")
public class CustomFault extends Exception {

	private static final long serialVersionUID = -5117949231987942830L;

	public CustomFault() {
		super();
	}

	public CustomFault(String message) {
		super(message);
	}
	
	public CustomFault(String message, Throwable cause) {
        super(message, cause);
    }

}