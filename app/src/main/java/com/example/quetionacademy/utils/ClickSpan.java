package com.example.quetionacademy.utils;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import org.jetbrains.annotations.NotNull;

public class ClickSpan extends ClickableSpan {

    private int color;
    private OnClickListener listener;



    public interface OnClickListener {
        void onClick();
    }

    public static void clickify(
            TextView view,
            final String clickableText,
            int color,
            int backgroundColor,
            final OnClickListener listener
    ) {
        clickify(view, clickableText, false, color, backgroundColor, listener);
    }

    private static void clickify(
            TextView view,
            final String clickableText,
            boolean withUnderline,
            int color,
            int backgroundColor,
            final OnClickListener listener
    ) {
        CharSequence text = view.getText();
        String string = text.toString();
        ClickSpan span = new ClickSpan(listener, color);
        int start = string.indexOf(clickableText);
        int end = start + clickableText.length();
        if (start == -1) {
            return;
        }

        if (text instanceof Spannable)
            ((Spannable) text).setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        else {
            SpannableString s = SpannableString.valueOf(text);
            s.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            s.setSpan(new RoundedBackgroundSpan(backgroundColor, color, 13, 8, 8, 0),
                    start, end,
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            view.setText(s);
        }

        MovementMethod m = view.getMovementMethod();
        if (!(m instanceof LinkMovementMethod)) {
            view.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static void clickify(
            TextView view,
            final String clickableText,
            int color,
            final OnClickListener listener
    ) {
        clickify(view, clickableText, false, color, listener);
    }

    public static void clickify(
            TextView view,
            final String clickableText,
            boolean withUnderline,
            int color,
            final OnClickListener listener
    ) {
        CharSequence text = view.getText();
        String string = text.toString();
        ClickSpan span = new ClickSpan(listener, color);
        int start = string.indexOf(clickableText);
        int end = start + clickableText.length();
        if (start == -1) {
            return;
        }

        if (text instanceof Spannable) {
            ((Spannable) text).setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } else {
            SpannableString s = SpannableString.valueOf(text);
            s.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            view.setText(s);
        }
    }

    private ClickSpan(OnClickListener listener, int color) {
        this.listener = listener;
        this.color = color;
    }

    @Override
    public void onClick(@NotNull View widget) {
        if (listener != null) listener.onClick();
    }

    @Override
    public void updateDrawState(@NotNull TextPaint paint) {
        super.updateDrawState(paint);
        paint.setUnderlineText(false);
        paint.setColor(color);
    }
}

class RoundedBackgroundSpan extends ReplacementSpan {

    private final int mBackgroundColor;
    private final int mTextColor;
    private final float mCornerRadius;
    private final float mPaddingStart;
    private final float mPaddingEnd;
    private final float mMarginStart;

    public RoundedBackgroundSpan(int backgroundColor, int textColor, float cornerRadius, float paddingStart, float paddingEnd, float marginStart) {
        super();
        mBackgroundColor = backgroundColor;
        mTextColor = textColor;
        mCornerRadius = cornerRadius;
        mPaddingStart = paddingStart;
        mPaddingEnd = paddingEnd;
        mMarginStart = marginStart;
    }

    @Override
    public int getSize(@NonNull Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return (int) (mPaddingStart + paint.measureText(text.subSequence(start, end).toString()) + mPaddingEnd);
    }

    @Override
    public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
        float width = paint.measureText(text.subSequence(start, end).toString());
        RectF rect = new RectF(x - mPaddingStart + mMarginStart, top - mPaddingStart, x + width + mPaddingEnd + mMarginStart, bottom - mPaddingEnd);
        paint.setColor(mBackgroundColor);
        canvas.drawRoundRect(rect, mCornerRadius, mCornerRadius, paint);
        paint.setColor(mTextColor);
        canvas.drawText(text, start, end, x + mMarginStart, y, paint);
    }
}