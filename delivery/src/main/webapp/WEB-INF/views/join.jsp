<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.form-inline label {
	display: -ms-flexbox;
	display: flex;
	-ms-flex-align: center;
	align-items: center;
	-ms-flex-pack: center;
	justify-content: center;
	margin-bottom: 0
}

.form-inline .form-group {
	display: -ms-flexbox;
	display: flex;
	-ms-flex: 0 0 auto;
	flex: 0 0 auto;
	-ms-flex-flow: row wrap;
	flex-flow: row wrap;
	-ms-flex-align: center;
	align-items: center;
	margin-bottom: 0
}

.form-inline .form-control {
	display: inline-block;
	width: auto;
	vertical-align: middle
}

.form-inline .form-control-plaintext {
	display: inline-block
}

.form-inline .custom-select, .form-inline .input-group {
	width: auto
}

.form-inline .custom-control {
	-ms-flex-align: center;
	align-items: center;
	-ms-flex-pack: center;
	justify-content: center
}

.form-inline .custom-control-label {
	margin-bottom: 0
}

}
.button-serch {
	display: inline-block;
	padding: .5em .75em;
	font-size: inherit;
	font-family: inherit;
	line-height: normal;
	vertical-align: right: 50px;
	background-color: #FE642E;
	border-bottom-color: #FE642E;
	border-radius: .25em;
}
</style>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>JOIN</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/fontAwesome.css">
<link rel="stylesheet" href="resources/css/hero-slider.css">
<link rel="stylesheet" href="resources/css/templatemo-main.css">
<link rel="stylesheet" href="resources/css/owl-carousel.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
	window.jQuery
			|| document
					.write(
							'<script src="resources/js/vendor/jquery-1.11.2.min.js"><\/script>')
</script>
<script src="resources/js/vendor/bootstrap.min.js"></script>
<script src="resources/js/plugins.js"></script>
<script src="resources/js/main.js"></script>


<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800"
	rel="stylesheet">

<script src="resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>

<body>
	<div class="fixed-side-navbar">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link" href="index"><span>Delivery</span></a></li>
			<li class="nav-item"><a class="nav-link" href="foodmaptest"><span>Search</span></a></li>
			<li class="nav-item"><a class="nav-link" href="login.html"><span>LOGIN</span></a></li>
			<li class="nav-item"><a class="nav-link" href="join.html"><span>JOIN</span></a></li>
			<li class="nav-item"><a class="nav-link" href="#contact-us"><span>TEST</span></a></li>
		</ul>
	</div>


	<div class="parallax-content baner-content" id="home">
		<div class="container">
			<div class="first-content">
				<h1>JOIN TEST</h1>
				<br>
				<p>
					<span><em>JOIN</em> TEST</span>
				</p>
				<br>
				<br>


				<div class="contact-form">
					<div class="form-group">

						<form id="contact" action="index.html" method="post">


							<div style="margin: 0 auto; width: 300px;">
								<fieldset>

									<input id="id" name="ID" class="group" type="text"
										class="form-control" id="ID" placeholder="ID"
										style="font-family: inherit; width: 300px; height: 40px;">

								</fieldset>


								<fieldset>

									<input id="m_name" name="NAME" type="text" class="form-control"
										id="NAME" placeholder="NAME"
										style="font-family: inherit; width: 300px; height: 40px;">

								</fieldset>

								<fieldset>

									<input id="pw" name="password" type="password"
										class="form-control" id="password" placeholder="PASSWORD"
										style="font-family: inherit; width: 300px; height: 40px;">
									<input id="pw2" name="password2" type="password"
										class="form-control" id="password"
										placeholder="PASSWORD CHECK"
										style="font-family: inherit; width: 300px; height: 40px;">
									<input type="hidden" name="${_csrf.parameterName }"
										value="${_csrf.token }" />
								</fieldset>

								<fieldset>

									<input id="email" name="email" type="Email"
										class="form-control" id="Email" placeholder="Email"
										style="font-family: inherit; width: 300px; height: 40px;">

								</fieldset>


								<fieldset>
									<div id="map"
										style="width: 300px; height: 300px; margin-top: 10px; display: none"></div>

									<script
										src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
									<script
										src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c1ae9605eb7fea18b91aa4e9f1d11e64&libraries=services"></script>
									<input type="text" id="sample5_address"
										placeholder="Address..."> <input type="text"
										id="sample5_address" placeholder="Detailed Address..."> <br>
									<input type="button" onclick="sample5_execDaumPostcode()"
										value="Address Search" class="ptn" style="width:300px; height:50px; text-align: left; font-family:inherit; font-size: 13px;
                                    background-color:#fd7e14; color:white; "><br>
									<div id="map" style="width:150px;height:150px;margin-top:10px;display:none"></div>

									<script
										src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
									<script
										src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c1ae9605eb7fea18b91aa4e9f1d11e64&libraries=services"></script>
									<script>
										var mapContainer = document
												.getElementById('map'), // 지도를 표시할 div
										mapOption = {
											center : new daum.maps.LatLng(
													37.537187, 127.005476), // 지도의 중심좌표
											level : 5
										// 지도의 확대 레벨
										};

										//지도를 미리 생성
										var map = new daum.maps.Map(
												mapContainer, mapOption);
										//주소-좌표 변환 객체를 생성
										var geocoder = new daum.maps.services.Geocoder();
										//마커를 미리 생성
										var marker = new daum.maps.Marker({
											position : new daum.maps.LatLng(
													37.537187, 127.005476),
											map : map
										});

										function sample5_execDaumPostcode() {
											new daum.Postcode(
													{
														oncomplete : function(
																data) {
															var addr = data.address; // 최종 주소 변수

															// 주소 정보를 해당 필드에 넣는다.
															document
																	.getElementById("sample5_address").value = addr;
															// 주소로 상세 정보를 검색
															geocoder
																	.addressSearch(
																			data.address,
																			function(
																					results,
																					status) {
																				// 정상적으로 검색이 완료됐으면
																				if (status === daum.maps.services.Status.OK) {

																					var result = results[0]; //첫번째 결과의 값을 활용

																					// 해당 주소에 대한 좌표를 받아서
																					var coords = new daum.maps.LatLng(
																							result.y,
																							result.x);
																					// 지도를 보여준다.
																					mapContainer.style.display = "block";
																					map
																							.relayout();
																					// 지도 중심을 변경한다.
																					map
																							.setCenter(coords);
																					// 마커를 결과값으로 받은 위치로 옮긴다.
																					marker
																							.setPosition(coords)
																				}
																			});
														}
													}).open();
										}
									</script>
								</fieldset>

								<fieldset>
									<input name="tel" type="number" class="form-control" id="TEL"
										placeholder="Phone number"
										style="font-family: inherit; width: 300px; height: 40px;">
								</fieldset>

								<fieldset>
									<font size="2em" color="white"> <input type="radio"
										name="owner"
										style="font-family: inherit; width: 19px; height: 19px"
										 value="female">owner
									</font>
								</fieldset>


								<fieldset>

									<p>
										<button type="button" id="join" class="btn"
											style="font-family: inherit; width: 200px; height: 60px;">JOIN</button>
									</p>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

								</fieldset>
						</form>
						</div>
					</div>
				</div>
			
		
		<div class="col-md-6"></div>

</div>
</div>
		<footer>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="primary-button">
							<a href="#home">Back To Top</a>
						</div>
						<ul>
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
							<li><a href="#"><i class="fa fa-google"></i></a></li>
							<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
	
	</footer>


	<script src="/resources/js/jquery3.3.1.min.js"></script>
	<script src="/resources/js/semantic.min.js"></script>
	<script>
		$(document).ready(
				function() {
					$("#join").click(
							function() {
								var json = {
									id : $("#id").val(),
									pw : $("#pw").val(),
									m_name : $("#m_name").val(),
									email : $("#email").val()

								};

								for ( var str in json) {
									if (json[str].length == 0) {
										alert($("#" + str).attr("placeholder")
												+ " 정보를 입력해주세요.");
										$("#" + str).focus();
										return false;
									}
								}
								if ($("#pw").val() == $("#pw2").val()) {
									$.ajax({
										type : "get",
										url : "/insertCustomer",
										data : json,
										success : function(string) {
											alert('가입 성공' + string);
										},
										error : function(error) {
											alert("이미존재하는 아이디 입니다.");
										}
									});
								} else {
									alert('비밀번호 가 일치하지 않습니다.');
								}
							});
				});
	</script>

</body>
</html>

