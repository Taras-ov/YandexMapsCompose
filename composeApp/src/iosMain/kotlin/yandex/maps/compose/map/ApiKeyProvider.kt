package yandex.maps.compose.map
import platform.Foundation.NSBundle


actual object ApiKeyProvider {
    actual val yandexMapKitApiKey: String
        get() = NSBundle.mainBundle.infoDictionary?.get("YANDEX_MAPKIT_API_KEY") as? String
            ?: error("YANDEX_MAPKIT_API_KEY not found in Info.plist")
}