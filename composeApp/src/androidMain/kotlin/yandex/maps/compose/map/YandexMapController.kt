package yandex.maps.compose.map

import android.content.Context
import android.view.View
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

actual class YandexMapController {
    private var mapView: MapView? = null

    actual fun initializeMap(context: Any?) {
        val ctx = context as Context
        MapKitFactory.initialize(ctx)

        mapView = MapView(ctx)
    }

    actual fun addMarker(latitude: Double, longitude: Double) {
        val point = Point(latitude, longitude)
        mapView?.map?.mapObjects?.addPlacemark(point)
    }

    actual fun moveTo(latitude: Double, longitude: Double) {
        val cameraPosition = CameraPosition(
            Point(latitude, longitude),
            15.0f, 0.0f, 0.0f
        )
        mapView?.map?.move(cameraPosition)
    }

    fun onStart() {
        MapKitFactory.getInstance().onStart()
        mapView?.onStart()
    }

    fun stopMap() {
        mapView?.onStop()
    }

    fun getMapView(): View? = mapView
}