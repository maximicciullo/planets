<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Planest Forecast Page</title>
    <style>
        .errorblock {
            color: #ff0000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body onload='document.f.j_username.focus();'>
<h3>Planets Forecast</h3>

<form name='f' action="/planetForecast" method='POST'>
    <table>
        <tr>
            <td>Cantidad de Anos a predecir:</td>
            <td><input type='text' name='years' value=''></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
        </tr>
        <tr>
            <td colspan='2'><input name="reset" type="reset" /></td>
        </tr>
    </table>
</form>
</body>
</html>