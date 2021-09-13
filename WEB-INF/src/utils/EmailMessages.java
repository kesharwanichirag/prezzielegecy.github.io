package utils;

public class EmailMessages{
	public static String getMail(String userName,String activationCode){
		String message = 	"<style>"+	
								"body{"+
									"margin: 0px auto;"+
									"font-family: arial;"+
								"}"+
								"#header{"+
									"height: 120px;"+
									"border-bottom: 2px solid #cf3c48;"+
									"margin: 0px auto;"+
								"}"+
								"#logo{"+
									"height: 120px;"+
									"margin-left: 30px;"+
								"}"+
								"#main_body{"+
									"text-align: center;"+
								"}"+
								"h3{"+
									"color: #cf3c48;"+
								"}"+
								"h4{"+
									"font-size: 22px;"+
								"}"+
								"h5{"+
									"font-size: 20px;"+
									"color: green;"+
								"}"+
								"a{"+
									"border: 1px solid green;"+
									"padding: 8px 20px;"+
									"background-color: #aaffaa;"+
									"color: black;"+
									"text-decoration: none;"+
									"font-size: 17px;"+
								"}"+
							"</style>"+
								"<div id='container'>"+
									"<div id='header'>"+
										"<img src='http://localhost:8080/gift/static/images/logo2.png' id='logo'>"+
									"</div>"+
									"<div id='main_body'>"+
										"<h3>Welcome to Prezzie Legacy(Wish with Gift)</h3>"+

										"<h4>Congratulations..."+userName+"! Your registeration is sucessfull</h4>"+
										
										"<h5>click over activation link to activate your Account</h5>"+
										
										"<a href='http://localhost:8080/gift/activation.do?userkey="+userName+"&activationcode="+activationCode+"'>Activate Your Account</a>"+
									"</div>"+
								"</div>";
				
	return message;
	}
}