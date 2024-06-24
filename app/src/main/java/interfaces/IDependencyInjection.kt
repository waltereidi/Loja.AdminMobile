package interfaces

import android.content.Context
import android.widget.ImageView

public interface IDependencyInjection {
    fun loadImage(context: Context, imageUrl: String, imageView: ImageView)
}