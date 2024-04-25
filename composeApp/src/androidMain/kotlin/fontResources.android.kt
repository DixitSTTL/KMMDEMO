import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font

@Composable
actual fun fontResources(font: String): Font {
    val context = LocalContext.current
    val fontRes = context.resources.getIdentifier(font, "font", context.packageName)
    return Font(fontRes)
}

