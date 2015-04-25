function createPanorama(viewElement, map, angle) {
    var panoramaOptions = {
        position: map.getCenter(),
        linksControl: false,
        addressControl: false,
        clickToGo: false,
        pov: {
            heading: angle,
            pitch: 10
        }
    };
    var panorama = new google.maps.StreetViewPanorama(viewElement, panoramaOptions);
    map.setStreetView(panorama);
}


function initializeViews(res) {
    var markers = res["points"];
    /*var markers = [
            {
                "title": 'Alibaug',
                "lat": '49.989727',
                "lng": '36.233556',
                "description": '1'
            }
        ,
            {
                "title": 'Mumbai',
                "lat": '49.989786',
                "lng": '36.23319',
                "description": '2'
            }
        ,
            {
                "title": 'Pune',
                "lat": '49.993149',
                "lng": '36.233553',
                "description": '3'
            }
    ];*/
    var mapOptions = {
            center: new google.maps.LatLng(markers[0].latitude, markers[0].longitude),
            zoom: 15,
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            disableDefaultUI: true,
            minZoom: 14
        };

    var map = new google.maps.Map(document.getElementById("map"), mapOptions);
    var infoWindow = new google.maps.InfoWindow();
    var lat_lng = new Array();
    var latlngbounds = new google.maps.LatLngBounds();
    for (i = 0; i < markers.length; i++) {
        var data = markers[i]
        var myLatlng = new google.maps.LatLng(data.latitude, data.longitude);
        lat_lng.push(myLatlng);
        var marker = new google.maps.Marker({
            position: myLatlng,
            map: map,
            title: data.title
        });
        latlngbounds.extend(marker.position);
        (function (marker, data) {
            google.maps.event.addListener(marker, "click", function (e) {
                infoWindow.setContent(data.description);
                infoWindow.open(map, marker);
            });
        })(marker, data);
    }
    map.setCenter(latlngbounds.getCenter());
    map.fitBounds(latlngbounds);

    //***********ROUTING****************//

    //Initialize the Path Array
    var path = new google.maps.MVCArray();

    //Initialize the Direction Service
    var service = new google.maps.DirectionsService();

    //Set the Path Stroke Color
    var poly = new google.maps.Polyline({ map: map, strokeColor: '#4986E7' });

    //Loop and Draw Path Route between the Points on MAP
    for (var i = 0; i < lat_lng.length; i++) {
        if ((i + 1) < lat_lng.length) {
            var src = lat_lng[i];
            var des = lat_lng[i + 1];
            path.push(src);
            poly.setPath(path);
            service.route({
                origin: src,
                destination: des,
                travelMode: google.maps.DirectionsTravelMode.DRIVING
            }, function (result, status) {
                if (status == google.maps.DirectionsStatus.OK) {
                    for (var i = 0, len = result.routes[0].overview_path.length; i < len; i++) {
                        path.push(result.routes[0].overview_path[i]);
                    }
                }
            });
        }
    }

    var isResising = false;

    $( "#map" ).mouseover(function() {
        if(isResising){
            return;
        }
        resize("20%", "30%");
    });

    $( "#map" ).mouseout(function() {
        if(isResising){
            return;
        }
        resize("10%", "20%");
    });

    function resize(width, height){
        isResising = true;
        $( "#map" ).animate({
            height: height,
            width: width
          },{
                duration: 100,
                step: function(  ){
                   google.maps.event.trigger(map,'resize');
                   map.setZoom(15);      // This will trigger a zoom_changed on the map
                   map.setCenter(new google.maps.LatLng(markers[0].latitude, markers[0].longitude));
                },
                complete: function() {
                    google.maps.event.trigger(map,'resize');
                    map.setZoom(15);      // This will trigger a zoom_changed on the map
                    map.setCenter(new google.maps.LatLng(markers[0].latitude, markers[0].longitude));
                    isResising = false;
                }
            });
    }

    var panorama = createPanorama(document.getElementById('panorama'), map, 150);
}