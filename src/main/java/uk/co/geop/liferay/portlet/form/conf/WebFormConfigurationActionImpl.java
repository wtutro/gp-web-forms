package uk.co.geop.liferay.portlet.form.conf;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Created by Bartłomiej Knabel on 26.06.17.
 */
public class WebFormConfigurationActionImpl extends DefaultConfigurationAction {
    /**
     *
     */
    @Override
    public final String render(final PortletConfig portletConfig, final RenderRequest renderRequest, final RenderResponse renderResponse)
            throws Exception {
        return "/views/conf/configuration.jsp";
    }
}
