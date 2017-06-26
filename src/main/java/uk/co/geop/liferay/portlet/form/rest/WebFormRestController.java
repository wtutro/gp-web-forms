package uk.co.geop.liferay.portlet.form.rest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import uk.co.geop.liferay.portlet.form.EmptyInputException;
import uk.co.geop.liferay.portlet.form.dto.WebFormDTO;
import uk.co.geop.liferay.portlet.form.validator.FormValidator;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Bartłomiej Knabel on 25.06.17.
 */
@Path("/webform")
public class WebFormRestController {

    private static final Log LOGGER = LogFactoryUtil.getLog(WebFormRestController.class);

    @POST
    @Path("/submit")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveWebForm(WebFormDTO formData) {
        LOGGER.info("Form submitted with parameters: " + formData);

        try {
            FormValidator.validateForm(formData);
        } catch (EmptyInputException e) {
            LOGGER.error("Validation failed", e);
            return Response.status(400).entity(e.getMessage()).build();
        }

        return Response.status(200).build();
    }

}
