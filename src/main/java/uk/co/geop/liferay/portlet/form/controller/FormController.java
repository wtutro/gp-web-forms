package uk.co.geop.liferay.portlet.form.controller;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import uk.co.geop.liferay.portlet.form.EmptyInputException;
import uk.co.geop.liferay.portlet.form.dto.WebFormBuilder;
import uk.co.geop.liferay.portlet.form.dto.WebFormDTO;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import static uk.co.geop.liferay.portlet.form.utils.WebFormConstants.*;

/**
 * @author Wojciech Tutro
 * @version 25-06-2017
 */
public class FormController extends MVCPortlet {

    private static final Log LOGGER = LogFactoryUtil.getLog(FormController.class);

    public void submitForm(ActionRequest request, ActionResponse response) {
        WebFormBuilder builder = new WebFormBuilder();
        WebFormDTO webFormDTO = null;
        //@formatter:off
        try {
            webFormDTO = builder.withFirstName(ParamUtil.getString(request, PARAM_FIRST_NAME))
                    .withLastName(ParamUtil.getString(request, PARAM_LAST_NAME))
                    .withEmail(ParamUtil.getString(request, PARAM_EMAIL))
                    .withComment(ParamUtil.getString(request, PARAM_COMMENT))
                    .withPortletId(ParamUtil.getString(request, PARAM_PORTLET_ID))
                    .withPlid(ParamUtil.getLong(request, PARAM_PLID))
                    .build();
        } catch (EmptyInputException e) {
            LOGGER.error("Validation failed", e);
            response.setRenderParameter("action", e.getMessage());
        }
        //@formatter:on
        response.setRenderParameter("action", "success");
    }
}
