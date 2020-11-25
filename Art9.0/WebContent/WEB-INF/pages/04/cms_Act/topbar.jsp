<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous"> -->
<!--     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" -->
<!--         integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"> -->
<!--     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" -->
<!--         integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" -->
<!--         crossorigin="anonymous"></script> -->
<!--     <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" -->
<!--         integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" -->
<!--         crossorigin="anonymous"></script> -->
<!--     <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" -->
<!--         integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" -->
<!--         crossorigin="anonymous"></script> -->
<style>
		body{
		margin:0px;
		padding:0px;
		}
        .topbar {
            background-color: #1B9AAA;
            height: 60px;
            margin: 0px;
            padding: 0px;
        }

        .nav{            
            float: left;
            color: #FFFFFF;    
            border-radius: 10px;
            list-style-type: none;
            font-size: 30px;
            margin: 5px;
            font-family: Microsoft JhengHei;
            
        }
        .nav:hover{
		background-color: #DDDBCB;
		color:#000000;
		    }
        .nav2{
            float: right;
            color: #F5F1E3;        
            border-radius: 10px;
            list-style-type: none;
            font-size: 30px;
            margin: 5px;
            font-family: Microsoft JhengHei;
        }
         .nav2:hover{
		background-color: #DDDBCB;
		color:#1B9AAA
		    }
	
		a:link {
		color:#FFFFFF;
		text-decoration:none;
		}
		a:visited {
		color:#FFFFFF;
		text-decoration:none;
		}
		a:hover {
		color:#000000;
		text-decoration:none;
		}



        
</style>
<body>

<header id="topbar" class="topbar">
            <nav>
                  <ul >
                    <li id="index"" class=" nav">
                       <a href="<c:url value='/index.jsp'/>" target="" title="" class="aa">首頁</a>
                       
                    </li>
         
                    
                    
              
                </ul>
            </nav>
        </header><br>
        

<!-- bootstrap匯入       -->
<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script> -->
<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script> -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous"> -->
        
</body>
</html>