package uk.co.geop.liferay.portlet.form.validator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import uk.co.geop.liferay.portlet.form.EmptyInputException;
import uk.co.geop.liferay.portlet.form.dto.WebFormDTO;

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

    private boolean validateAbusedWords(String content) throws SystemException, PortalException {
        final String groupName = GroupConstants.GUEST;
        final long companyId = PortalUtil.getDefaultCompanyId();
        long groupId = GroupLocalServiceUtil.getGroup(companyId, groupName).getGroupId();
        PortletPreferences portletPreferences = PortletPreferencesLocalServiceUtil
                .getPortletPreferences(groupId, PortletKeys.PREFS_OWNER_TYPE_GROUP, 0, "gpwebforms_WAR_gpwebformsportlet");
        javax.portlet.PortletPreferences prefs = PortletPreferencesFactoryUtil.fromDefaultXML(portletPreferences.getPreferences());
        String abusingWords = GetterUtil.getString(prefs.getValue("assetCategoryIds", null), null);

        return false;
    }

    public static boolean validateForm(WebFormDTO formData) {
        return validateForm(formData.getFirstName(), formData.getLastName(), formData.getEmail(), formData.getComment());
    }
}
