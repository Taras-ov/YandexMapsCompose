package yandex.maps.compose.map.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitView
import yandex.maps.compose.map.YandexMapController

@Composable
actual fun MapView(modifier: Modifier) {
    UIKitView(
        modifier = modifier,
        factory = {
            val controller = YandexMapController()
            controller.initializeMap(null)
            controller.getView()!!
        }
    )
}