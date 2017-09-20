package cn.carbswang.android.numberpickerview.library;

import android.content.Context;
import android.graphics.Typeface;
import java.util.HashMap;

/**
 * Class used for loading font. Helps in preventing memory leak.
 */
public class FontCache {

  private static HashMap<String, Typeface> fontCache = new HashMap<>();

  public static Typeface getTypeface(final String fontname, final Context context) {
    Typeface typeface = fontCache.get(fontname);

    if (typeface == null) {
      try {
        typeface = Typeface.createFromAsset(context.getAssets(), fontname);
      } catch (Exception e) {
        return null;
      }

      fontCache.put(fontname, typeface);
    }

    return typeface;
  }
}
