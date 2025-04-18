package yandex.maps.compose.map

import cocoapods.YandexMapsMobile.YMKCameraPosition
import cocoapods.YandexMapsMobile.YMKMapKit
import cocoapods.YandexMapsMobile.YMKMapView
import cocoapods.YandexMapsMobile.YMKPoint
import cocoapods.YandexMapsMobile.sharedInstance
import kotlinx.cinterop.ExperimentalForeignApi
import platform.CoreGraphics.CGRectMake
import platform.UIKit.UIView

actual class YandexMapController {


    @OptIn(ExperimentalForeignApi::class)
    private var mapView: YMKMapView? = null

    @OptIn(ExperimentalForeignApi::class)
    actual fun initializeMap(context: Any?) {
        val frame = CGRectMake(0.0, 0.0, 300.0, 300.0) // Можно будет вынести как параметр
        mapView = YMKMapView(frame = frame)
        YMKMapKit.sharedInstance()
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun addMarker(latitude: Double, longitude: Double) {
        val point = YMKPoint.pointWithLatitude(latitude, longitude)
        mapView?.mapWindow?.map?.mapObjects?.addPlacemarkWithPoint(point)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun moveTo(latitude: Double, longitude: Double) {
        val point = YMKPoint.pointWithLatitude(latitude, longitude)
        val cameraPosition = YMKCameraPosition.cameraPositionWithTarget(point, 15.0f, 0.0f, 0.0f)
        mapView?.mapWindow?.map?.moveWithCameraPosition(cameraPosition)
    }

    @OptIn(ExperimentalForeignApi::class)
    fun getView(): UIView? = mapView
}