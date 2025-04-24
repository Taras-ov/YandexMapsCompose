package yandex.maps.compose.map.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import yandex.maps.compose.map.YandexMapController

@Composable
actual fun MapView(modifier: Modifier) {
    val mapController = remember {
        YandexMapController()
    }

    AndroidView(
        modifier = modifier,
        factory = { context ->
            mapController.initializeMap(context)
            mapController.getMapView()!!
        },
        update = {
            mapController.moveTo(55.030199, 82.920430)
        }
    )
    DisposableEffect(Unit) {
        mapController.onStart()
        onDispose {
            mapController.stopMap()
        }
    }
}