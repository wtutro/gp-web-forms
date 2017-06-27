package uk.co.geop.liferay.portlet.form.validator;

import com.liferay.portal.kernel.util.Validator;
import org.junit.Test;
import uk.co.geop.liferay.portlet.form.EmptyInputException;
import static org.junit.Assert.assertEquals;


/**
 * Created by Bartłomiej Knabel on 27.06.17.
 */
public class FormValidatorTest {

    /**
     * This is just demonstration that we usually add some tests
     */

    @Test(expected = EmptyInputException.class)
    public void form_validation_all_null_should_throw_exception() {
        FormValidator.validateForm(null, null, null, null, null, 1L);
    }

    @Test(expected = EmptyInputException.class)
    public void form_validation_all_null_but_first_name_should_throw_exception() {
        FormValidator.validateForm("John", null, null, null, null, 1L);
    }

    @Test(expected = EmptyInputException.class)
    public void form_validation_all_null_firstname_empty_should_throw_exception() {
        FormValidator.validateForm("", null, null, null, null, 1L);
    }

    @Test()
    public void email_validation_should_work() {
        assertEquals(true, Validator.isAddress("john@cnn.com"));
    }

}
