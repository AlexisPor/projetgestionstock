package persistance.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {
	
	private String emailPattern=".+@.+\\..";
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		Pattern patter=Pattern.compile(emailPattern);
		Matcher matcher=patter.matcher(value.toString());
		
		if(matcher.matches()) {
			FacesMessage msg = new FacesMessage("Format d'email est invalide");
			
			throw new ValidatorException(msg);
		}
		
	}

}
