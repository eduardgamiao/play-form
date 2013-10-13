package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;

/**
 * Provides backing class for NewContact page form.
 */
public class ContactFormData {
  private static final int TELEPHONE_NUMBER_AMOUNT = 12;
  
  /** First name field. */
  public String firstName = "";
  
  /** Last name field. */
  public String lastName = "";
  
  /** Telephone field. */
  public String telephone = "";
  
  /**
   * Implements form validation.
   * @return A list of errors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<ValidationError>();
    
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }
    else if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }
    else if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone is required."));
    }
    else if (telephone.length() != TELEPHONE_NUMBER_AMOUNT) {
      errors.add(new ValidationError("telephone", "Telephone must be formatted as xxx-xxx-xxxx."));
    }
    
    return errors.isEmpty() ? null : errors;
  }

}
