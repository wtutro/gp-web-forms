package uk.co.geop.liferay.portlet.form.validator;

import com.liferay.portal.kernel.util.Validator;
import uk.co.geop.liferay.portlet.form.EmptyInputException;

/**
 * @author Wojciech Tutro
 * @version 25-06-2017
 */
public class FormValidator {

    public static boolean validateForm(String firstName, String lastName, String email, String comment) {
        if (Validator.isNull(firstName)) {
            throw new EmptyInputException("firstName is empty");
        }
        if (Validator.isNull(lastName)) {
            throw new EmptyInputException("lastName is empty");
        }
        if (Validator.isNull(email)) {
            throw new EmptyInputException("email is empty");
        }
        // TODO validate email format
        if (Validator.isNull(comment)) {
            throw new EmptyInputException("comment is empty");
        }
        // TODO validate abuse words in comment
        return true;
    }
}
