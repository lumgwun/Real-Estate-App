package com.ls.awajimatradeeder.Classes;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.ls.awajimatradeeder.R;

public class PinEntryView extends ViewGroup {


    public static final int ACCENT_NONE = 0;
    public static final int ACCENT_ALL = 1;
    public static final int ACCENT_CHARACTER = 2;

    private int digits;

    private int inputType;

    private int digitWidth;
    private int digitHeight;
    private int digitBackground;
    private int digitSpacing;
    private int digitTextSize;
    private int digitTextColor;
    private int digitElevation;

    private int accentType;
    private int accentWidth;
    private int accentColor;


    private String mask = "*";


    private EditText editText;


    private OnFocusChangeListener onFocusChangeListener;


    private OnPinEnteredListener onPinEnteredListener;

    private boolean accentRequiresFocus;

    public PinEntryView(Context context) {
        this(context, null);
    }

    public PinEntryView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PinEntryView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.PinEntryView);
        digits = array.getInt(R.styleable.PinEntryView_numDigits, 4);
        inputType = array.getInt(R.styleable.PinEntryView_pinInputType, InputType.TYPE_CLASS_NUMBER);
        accentType = array.getInt(R.styleable.PinEntryView_accentType, ACCENT_NONE);

        // Dimensions
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        digitWidth = array.getDimensionPixelSize(R.styleable.PinEntryView_digitWidth,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, metrics));
        digitHeight = array.getDimensionPixelSize(R.styleable.PinEntryView_digitHeight,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, metrics));
        digitSpacing = array.getDimensionPixelSize(R.styleable.PinEntryView_digitSpacing,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, metrics));
        digitTextSize = array.getDimensionPixelSize(R.styleable.PinEntryView_digitTextSize,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 15, metrics));
        accentWidth = array.getDimensionPixelSize(R.styleable.PinEntryView_accentWidth,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, metrics));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            digitElevation = array.getDimensionPixelSize(R.styleable.PinEntryView_digitElevation, 0);
        }

        Resources.Theme theme = getContext().getTheme();

        TypedValue background = new TypedValue();
        theme.resolveAttribute(android.R.attr.windowBackground, background, true);
        digitBackground = array.getResourceId(R.styleable.PinEntryView_digitBackground,
                background.resourceId);

        TypedValue textColor = new TypedValue();
        theme.resolveAttribute(android.R.attr.textColorPrimary, textColor, true);
        digitTextColor = array.getColor(R.styleable.PinEntryView_digitTextColor,
                textColor.resourceId > 0 ? getResources().getColor(textColor.resourceId) :
                        textColor.data);

        TypedValue accentColor = new TypedValue();

        theme.resolveAttribute(R.attr.colorAccent, accentColor, true);
        this.accentColor = array.getColor(R.styleable.PinEntryView_pinAccentColor,
                accentColor.resourceId > 0 ? getResources().getColor(accentColor.resourceId) :
                        accentColor.data);

        // Mask character
        String maskCharacter = array.getString(R.styleable.PinEntryView_mask);
        if (maskCharacter != null) {
            mask = maskCharacter;
        }

        accentRequiresFocus = array.getBoolean(R.styleable.PinEntryView_accentRequiresFocus, true);

        array.recycle();

        // Add child views
        addViews();
    }

    @Override public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Calculate the size of the view
        int width = (digitWidth * digits) + (digitSpacing * (digits - 1));
        setMeasuredDimension(
                width + getPaddingLeft() + getPaddingRight() + (digitElevation * 2),
                digitHeight + getPaddingTop() + getPaddingBottom() + (digitElevation * 2));

        int height = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MeasureSpec.EXACTLY);

        // Measure children
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).measure(width, height);
        }
    }

    @Override protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // Position the text views
        for (int i = 0; i < digits; i++) {
            View child = getChildAt(i);
            int left = i * digitWidth + (i > 0 ? i * digitSpacing : 0);
            child.layout(
                    left + getPaddingLeft() + digitElevation,
                    getPaddingTop() + (digitElevation / 2),
                    left + getPaddingLeft() + digitElevation + digitWidth,
                    getPaddingTop() + (digitElevation / 2) + digitHeight);
        }

        // Add the edit text as a 1px wide view to allow it to focus
        getChildAt(digits).layout(0, 0, 1, getMeasuredHeight());
    }

    @Override public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // Make sure this view is focused
            editText.requestFocus();

            // Show keyboard
            InputMethodManager inputMethodManager = (InputMethodManager) getContext()
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.showSoftInput(editText, 0);
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override protected Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        SavedState savedState = new SavedState(parcelable);
        savedState.editTextValue = editText.getText().toString();
        return savedState;
    }

    @Override protected void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        editText.setText(savedState.editTextValue);
        editText.setSelection(savedState.editTextValue.length());
    }

    @Override public OnFocusChangeListener getOnFocusChangeListener() {
        return onFocusChangeListener;
    }

    @Override public void setOnFocusChangeListener(OnFocusChangeListener l) {
        onFocusChangeListener = l;
    }


    public void addTextChangedListener(TextWatcher watcher) {
        editText.addTextChangedListener(watcher);
    }


    public void removeTextChangedListener(TextWatcher watcher) {
        editText.removeTextChangedListener(watcher);
    }


    public OnPinEnteredListener getOnPinEnteredListener() {
        return onPinEnteredListener;
    }


    public void setOnPinEnteredListener(OnPinEnteredListener onPinEnteredListener) {
        this.onPinEnteredListener = onPinEnteredListener;
    }

    public Editable getText() {
        return editText.getText();
    }

    public void setText(CharSequence text) {
        if (text.length() > digits) {
            text = text.subSequence(0, digits);
        }
        editText.setText(text);
    }

    /**
     * Clear pin input
     */
    public void clearText() {
        editText.setText("");
    }

    public int getDigits() {
        return digits;
    }

    public int getInputType() {
        return inputType;
    }

    public int getAccentType() {
        return accentType;
    }

    public int getDigitWidth() {
        return digitWidth;
    }

    public int getDigitHeight() {
        return digitHeight;
    }

    public int getDigitSpacing() {
        return digitSpacing;
    }

    public int getDigitTextSize() {
        return digitTextSize;
    }

    public int getAccentWidth() {
        return accentWidth;
    }

    public int getDigitElevation() {
        return digitElevation;
    }

    public int getDigitBackground() {
        return digitBackground;
    }

    public int getDigitTextColor() {
        return digitTextColor;
    }

    public int getAccentColor() {
        return accentColor;
    }

    public String getMask() {
        return mask;
    }

    public boolean getAccentRequiresFocus() {
        return accentRequiresFocus;
    }

    private void addViews() {
        for (int i = 0; i < digits; i++) {
            DigitView digitView = new DigitView(getContext());
            digitView.setWidth(digitWidth);
            digitView.setHeight(digitHeight);
            digitView.setBackgroundResource(digitBackground);
            digitView.setTextColor(digitTextColor);
            digitView.setTextSize(TypedValue.COMPLEX_UNIT_PX, digitTextSize);
            digitView.setGravity(Gravity.CENTER);
            digitView.setElevation(digitElevation);
            addView(digitView);
        }

        // Add an "invisible" edit text to handle input
        editText = new EditText(getContext());
        editText.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        editText.setTextColor(getResources().getColor(android.R.color.transparent));
        editText.setCursorVisible(false);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(digits)});
        editText.setInputType(inputType);
        editText.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override public void onFocusChange(View v, boolean hasFocus) {
                // Update the selected state of the views
                int length = editText.getText().length();
                for (int i = 0; i < digits; i++) {
                    getChildAt(i).setSelected(hasFocus && (accentType == ACCENT_ALL ||
                            (accentType == ACCENT_CHARACTER && (i == length ||
                                    (i == digits - 1 && length == digits)))));
                }

                // Make sure the cursor is at the end
                editText.setSelection(length);

                // Provide focus change events to any listener
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(PinEntryView.this, hasFocus);
                }
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override public void afterTextChanged(Editable s) {
                int length = s.length();
                for (int i = 0; i < digits; i++) {
                    if (s.length() > i) {
                        String mask = PinEntryView.this.mask == null || PinEntryView.this.mask.length() == 0 ?
                                String.valueOf(s.charAt(i)) : PinEntryView.this.mask;
                        ((TextView) getChildAt(i)).setText(mask);
                    } else {
                        ((TextView) getChildAt(i)).setText("");
                    }
                    if (editText.hasFocus()) {
                        getChildAt(i).setSelected(accentType == ACCENT_ALL ||
                                (accentType == ACCENT_CHARACTER && (i == length ||
                                        (i == digits - 1 && length == digits))));
                    }
                }

                if (length == digits && onPinEnteredListener != null) {
                    onPinEnteredListener.onPinEntered(s.toString());
                }
            }
        });
        addView(editText);
    }

    static class SavedState extends BaseSavedState {

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
                    @Override public SavedState createFromParcel(Parcel in) {
                        return new SavedState(in);
                    }

                    @Override public SavedState[] newArray(int size) {
                        return new SavedState[size];
                    }
                };
        String editTextValue;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel source) {
            super(source);
            editTextValue = source.readString();
        }

        @Override public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeString(editTextValue);
        }

    }

    private class DigitView extends androidx.appcompat.widget.AppCompatTextView {


        private Paint paint;

        public DigitView(Context context) {
            this(context, null);
        }

        public DigitView(Context context, AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public DigitView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);

            paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(accentColor);
        }

        @Override protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            if (isSelected() || !accentRequiresFocus) {
                canvas.drawRect(0, getHeight() - accentWidth, getWidth(), getHeight(), paint);
            }
        }

    }

    public interface OnPinEnteredListener {
        void onPinEntered(String pin);
    }
}
