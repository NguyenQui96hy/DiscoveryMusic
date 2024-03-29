package com.vmodev.cibes.widget

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.utehy.discovermusic.R
import com.utehy.discovermusic.widget.FontCache


class CustomFontTextView : AppCompatTextView {
//    val ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android"
//    https://futurestud.io/tutorials/custom-fonts-on-android-dynamic-font-selection-via-xml

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        applyCustomFont(context, attrs)
    }

    constructor (context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        applyCustomFont(context, attrs)
    }

    private fun applyCustomFont(context: Context, attrs: AttributeSet) {
        val attributeArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.CustomFontTextView)

        val fontName = attributeArray.getString(R.styleable.CustomFontTextView_customFont)
//        val textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL)

        val customFont = selectTypeface(context,  fontName)
        typeface = customFont

        attributeArray.recycle()
    }

    private fun selectTypeface(context: Context, fontName: String?): Typeface? {
        if(null==fontName){
            return FontCache.getTypeface("SFProText-Regular.ttf", context)
        }
        try {
            return FontCache.getTypeface(fontName, context)
        }catch (e :Exception){
            return FontCache.getTypeface("SFProText-Regular.ttf", context)
        }

//        when (textStyle) {
//            Typeface.BOLD // bold
//            ->
//
//            Typeface.ITALIC // italic
//            -> return FontCache.getTypeface("SourceSansPro-Italic.ttf", context)
//
//            Typeface.BOLD_ITALIC // bold italic
//            -> return FontCache.getTypeface("SourceSansPro-BoldItalic.ttf", context)
//
//            Typeface.NORMAL // regular
//            -> return FontCache.getTypeface("SourceSansPro-Regular.ttf", context)
//            else -> return FontCache.getTypeface("SFProText-Regular.ttf", context)
//        }
    }
}