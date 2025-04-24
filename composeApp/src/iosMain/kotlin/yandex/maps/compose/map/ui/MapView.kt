package yandex.maps.compose.map.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitView
import yandex.maps.compose.map.YandexMapController

@Composable
actual fun MapView(modifier: Modifier) {
    val controller = remember { YandexMapController() }

    UIKitView(
        modifier = modifier,
        factory = {
            controller.initializeMap(null)
            controller.getView()!!
        },
        update = {
            controller.moveTo(55.030199, 82.920430)
        }
    )
}