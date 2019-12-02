<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sandstone/bootstrap.min.css" rel="stylesheet" integrity="sha384-G3Fme2BM4boCE9tHx9zHvcxaQoAkksPQa/8oyn1Dzqv7gdcXChereUsXGx6LtbqA" crossorigin="anonymous">
		<%@ include file="errorHeader.jspf" %>
	</head>
	<body>
		
		<form id="getNewDeck" action="/get-deck">
			<input type="submit" value="Get New Shuffled Deck" class="btn btn-primary"/>
		</form>
		
		<c:if test='${ pageContext.session.getAttribute("deck") != null }'>
			<div class="jumbotron">
				
				<div class="container">	
					<h1> Deck ${ pageContext.session.getAttribute("deck").getDeck_id() }</h1>
				</div>
				
				<div class="container">
					<table class="table">
						<tbody>
							<tr>
								<td>Shuffled?</td>
								<td>${ pageContext.session.getAttribute("deck").isShuffled() }</td>	
							</tr>
							<tr>
								<td>Cards Remaining</td>
								<td>${ pageContext.session.getAttribute("deck").getRemaining() }</td>
							</tr>
						</tbody>
					</table>
				</div>
			
			</div>
		</c:if>
		
		
	</body>
</html>