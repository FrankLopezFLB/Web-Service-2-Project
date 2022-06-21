package proy.serpost.response.http;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String status;
	private HttpStatus code;
	private ErrorClass error;
	private String texto;
	private Object data;
	
	
	public HttpResponseObject(String status, HttpStatus code, Object data) {
		super();
		this.status = status;
		this.code = code;
		this.data = data;
	}


	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	private class ErrorClass {
		private HttpStatus code;
		private String message;
		private String content;
		
		public Boolean existsError() {
			if(this.code!=null)
				return true;
			return false;
		}
	}
	

}
