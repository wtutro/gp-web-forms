<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ include file="/views/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="actionURL"/>

<h2>
    <liferay-ui:message key="configuration"/>
</h2>

<aui:form action="<%=actionURL%>" method="post" name="confForm">
<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>"/>

<aui:input name="preferences--abusingWords--" type="textarea" label="abusingWords.label" value="<%=abusingWords%>"/>

<aui:button-row>
    <aui:button type="submit"/>
</aui:button-row>

</aui:form>