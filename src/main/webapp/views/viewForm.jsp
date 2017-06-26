<%@ include file="init.jsp" %>

<liferay-portlet:actionURL name="submitForm" var="submitFormURL"/>

<aui:form name="gp-form" action="<%= submitFormURL %>" onSubmit="event.preventDefault();">
    <liferay-ui:success key="success" message="success"/>

    <aui:fieldset>
        <aui:row>
            <aui:col>
                <aui:input name="firstName" type="text" label="first.name"/>
                <aui:input name="lastName" type="text" label="last.name"/>
                <aui:input name="email" type="email" label="email"/>
                <aui:input name="comment" type="textarea" label="comment"/>
            </aui:col>
        </aui:row>
    </aui:fieldset>

    <aui:button type="submit"/>
</aui:form>

<script type="text/javascript">
    new AUI().use('gp-web-form', function (A) {
        var gpForm = new Liferay.Portlet.GPForm('<portlet:namespace/>', A.one('#<portlet:namespace/>' + 'gp-form'), '');
        gpForm.init();
    });
</script>
