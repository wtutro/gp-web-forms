package uk.co.geop.liferay.portlet.form.dto;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import uk.co.geop.liferay.portlet.form.validator.FormValidator;

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
    private String portletId;
    private long plid;

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

    public WebFormBuilder withPortletId(String portletId) {
        this.portletId = portletId;
        return this;
    }

    public WebFormBuilder withPlid(long plid) {
        this.plid = plid;
        return this;
    }

    public WebFormDTO build() {
        if (FormValidator.validateForm(firstName, lastName, email, comment, portletId, plid)) {
            LOGGER.info("All fields are valid");
        }
        return new WebFormDTO(firstName, lastName, email, comment, portletId, plid);
    }

}
