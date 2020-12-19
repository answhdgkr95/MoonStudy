<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
    <title>Map Test</title>
    
</head>
<body>

<div id="map" style="width:100%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c1ae9605eb7fea18b91aa4e9f1d11e64&libraries=services,clusterer,drawing"></script>


<script>

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = { 
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 10 // 지도의 확대 레벨 
}; 

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성

//HTML5의 geolocation으로 사용할 수 있는지 확인
if (navigator.geolocation) {

// GeoLocation을 이용해서 접속 위치를 얻음
navigator.geolocation.getCurrentPosition(function(position) {
    
    var lat = position.coords.latitude, // 위도
        lon = position.coords.longitude; // 경도
    
    var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성 
        message = '<div style="padding:5px;">현재위치</div>'; // 인포윈도우에 표시될 내용 
    
    // 마커와 인포윈도우를 표시 
    displayMarker(locPosition, message);
        
  });

} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정 

var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
    message = 'geolocation을 사용ㄴㄴㄴㄴ'
    
displayMarker(locPosition, message);
}

//지도에 마커와 인포윈도우를 표시하는 함수 
function displayMarker(locPosition, message) {

// 마커를 생성 
var marker = new kakao.maps.Marker({  
    map: map, 
    position: locPosition
}); 

var iwContent = message, // 인포윈도우에 표시할 내용
    iwRemoveable = true;

// 인포윈도우를 생성
var infowindow = new kakao.maps.InfoWindow({
    content : iwContent,
    removable : iwRemoveable
});

// 인포윈도우를 마커위에 표시  
infowindow.open(map, marker);

// 지도 중심좌표를 접속위치로 변경 
map.setCenter(locPosition);      
}    






//지도 추가 기능 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


// 지도 타입 변경 컨트롤을 생성한다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도의 상단 우측에 지도 타입 변경 컨트롤을 추가한다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);	

// 지도에 확대 축소 컨트롤을 생성한다
var zoomControl = new kakao.maps.ZoomControl();

// 지도의 우측에 확대 축소 컨트롤을 추가한다
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

// 지도 중심 좌표 변화 이벤트를 등록한다
kakao.maps.event.addListener(map, 'center_changed', function () {
	console.log('지도의 중심 좌표는 ' + map.getCenter().toString());
});

// 지도 확대 레벨 변화 이벤트를 등록한다
kakao.maps.event.addListener(map, 'zoom_changed', function () {
	console.log('지도의 현재 확대레벨은 ' + map.getLevel());
});

// 지도 영역 변화 이벤트를 등록한다
kakao.maps.event.addListener(map, 'bounds_changed', function () {
	var mapBounds = map.getBounds(),
		message = '지도의 남서쪽, 북동쪽 영역좌표는 ' +
					mapBounds.toString();

	console.log(message);	
});


// 지도 시점 변화 완료 이벤트를 등록한다
kakao.maps.event.addListener(map, 'idle', function () {
	var message = '지도의 중심좌표는 ' + map.getCenter().toString() + ' 이고,' + 
					'확대 레벨은 ' + map.getLevel() + ' 레벨';
	console.log(message);
});

// 지도 클릭 이벤트를 등록한다 (좌클릭 : click, 우클릭 : rightclick, 더블클릭 : dblclick)
kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
	console.log('지도에서 클릭한 위치의 좌표는 ' + mouseEvent.latLng.toString());
});	

// 지도 드래깅 이벤트를 등록한다 (드래그 시작 : dragstart, 드래그 종료 : dragend)
kakao.maps.event.addListener(map, 'drag', function () {
	var message = '지도를 드래그 ' + 
					'지도의 중심 좌표는 ' + map.getCenter().toString();
	console.log(message);
});


</script>
</body>
</html>