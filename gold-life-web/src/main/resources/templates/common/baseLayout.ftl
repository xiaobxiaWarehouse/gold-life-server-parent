<#macro page title="Default" description="" head_bottom="" body_top="" body_bottom="">
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <meta name="description" content="${description}">
${head_bottom}
</head>
<body>
${body_top}
<#-- This processes the enclosed content:  -->
    <#nested>
${body_bottom}
</body>
</html>
</#macro>
