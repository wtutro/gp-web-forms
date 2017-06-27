package uk.co.geop.liferay.portlet.form;

/**
 * @author Wojciech Tutro
 * @version 25-06-2017
 */
public class EmptyInputException extends RuntimeException {
    public EmptyInputException(String message) {
        super(message);
    }
}
