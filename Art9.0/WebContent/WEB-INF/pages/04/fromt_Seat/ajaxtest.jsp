<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Weather App</title>
</head>
<body>
  <div id="weather"></div>
  <script>
  
    function makeRequest() {
      xhr = new XMLHttpRequest();
      xhr.onload= function() {
        // 這邊處理傳回來的東西
      }
      xhr.open('GET','https://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=9c39fa3ce9d953fdd507d7d9f77093ef', true )  
      xhr.send()
      }
      makeRequest();

      xhr.onload= function() {
          // 這邊處理傳回來的東西
          console.log(this.responseText)
        }
  </script>
</body>
</html>