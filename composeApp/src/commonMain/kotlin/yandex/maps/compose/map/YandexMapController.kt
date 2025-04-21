package yandex.maps.compose.map

expect class YandexMapController {
    fun initializeMap(context: Any?)
    fun addMarker(latitude: Double, longitude: Double)
    fun moveTo(latitude: Double, longitude: Double)
}