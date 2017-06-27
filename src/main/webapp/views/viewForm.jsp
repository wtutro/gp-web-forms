<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ include file="init.jsp" %>

<div>
    <aui:form name="gp-form" onSubmit="event.preventDefault();">
        <aui:fieldset>
            <aui:row>
                <aui:col>
                    <aui:input name="firstName" type="text" label="first.name" required="true"/>
                    <aui:input name="lastName" type="text" label="last.name" required="true"/>
                    <aui:input name="email" type="email" label="email" required="true"/>
                    <aui:input name="comment" type="textarea" label="comment" required="true"/>
                </aui:col>
            </aui:row>
        </aui:fieldset>

        <aui:button type="submit"/>
    </aui:form>
</div>

<script type="text/javascript">
    new AUI().use('gp-web-form', function (A) {
        var gpForm = new Liferay.Portlet.GPForm('<portlet:namespace/>', A.one('#<portlet:namespace/>' + 'gp-form'), <%= plid %>, '<%= HtmlUtil.escapeJS(contactTime) %>');
        gpForm.init();
    });
</script>
