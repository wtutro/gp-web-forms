package uk.co.geop.liferay.portlet.form.dto;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Wojciech Tutro
 * @version 25-06-2017
 */
public class WebFormBuilder {

    private static final Log LOGGER = LogFactoryUtil.getLog(WebFormBuilder.class);

    private String firstName;
    private String lastName;
    private String email;
    private String comment;

    public WebFormBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public WebFormBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public WebFormBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public WebFormBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public WebFormDTO build() {
        // TODO validators

        return new WebFormDTO(firstName, lastName, email, comment);
    }

}