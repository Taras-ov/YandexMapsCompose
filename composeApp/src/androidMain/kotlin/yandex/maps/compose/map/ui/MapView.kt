package yandex.maps.compose.map.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import yandex.maps.compose.map.YandexMapController

@Composable
actual fun MapView(modifier: Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            val mapController = YandexMapController()
            mapController.initializeMap(context)
            mapController.getMapView()!!
        }
    )
}