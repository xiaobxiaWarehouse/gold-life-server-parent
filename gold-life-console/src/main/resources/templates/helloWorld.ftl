<#import "common/baseLayout.ftl" as baseLayout>
<@baseLayout.page title="Index">
welcome ${name} to FreeMarker!

<hr/>
<p>Cookie list is</p>
    <#assign cookies = request.getCookies()>
    <#list cookies as cookie>
    ${cookie.name}=${cookie.value} <br/>
    </#list>
</@baseLayout.page>