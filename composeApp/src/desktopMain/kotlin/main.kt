import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import common.di.appModule
import common.presentation.app.App
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun main() = application {
    startKoin { modules(appModule(KoinApplication.init())) }

    Window(onCloseRequest = ::exitApplication, title = "KMMDEMO") {
        App()
    }
}

@Preview
@Composable
fun AppDesktopPreview() {

    App()
}