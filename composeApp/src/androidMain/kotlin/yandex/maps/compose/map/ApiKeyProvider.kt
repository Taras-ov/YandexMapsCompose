package yandex.maps.compose.map

import yandex.maps.compose.BuildConfig

actual object ApiKeyProvider {
    actual val yandexMapKitApiKey: String
        get() = BuildConfig.YANDEX_MAPKIT_API_KEY
}