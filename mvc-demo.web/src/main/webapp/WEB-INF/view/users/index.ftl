<html>
<head>
    <title>mvc demo</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <td>id</td>
                <td>name</td>
            </tr>
        </thead>
        <tbody>
            <#list users as user>
                <tr>
                    <td>
                        ${user.getId()}
                    </td>
                    <td>
                        ${user.getName()}
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>
