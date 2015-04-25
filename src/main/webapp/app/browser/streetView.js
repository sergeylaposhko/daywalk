function createPanorama(viewElement, map, angle) {
    var panoramaOptions = {
        position: map.getCenter(),
        linksControl: false,
        addressControl: false,
        pov: {
            heading: angle,
            pitch: 10
        }
    };
    var panorama = new google.maps.StreetViewPanorama(viewElement, panoramaOptions);
    map.setStreetView(panorama);
}


function initializeViews() {
    var coordinates = new google.maps.LatLng(42.345573, -71.098326);
    var mapOptions = {
        center: coordinates,
        zoom: 14
    };
    var map = new google.maps.Map(
        document.getElementById('map-canvas'), mapOptions);
    var panorama = createPanorama(document.getElementById('panorama'), map, 150);
}

//google.maps.event.addDomListener(window, 'load', initialize);