package it.gtd.abreakout;

import android.os.Bundle;
import android.view.KeyEvent;
import org.kde.necessitas.origo.QtActivity;
import org.kde.necessitas.origo.QtApplication;

public class GameActivity extends QtActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int newKeyCode = keyCode;
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            newKeyCode = KeyEvent.KEYCODE_MEDIA_PREVIOUS;
        }

        if (QtApplication.m_delegateObject != null && QtApplication.onKeyDown != null) {
            return (Boolean)QtApplication
                    .invokeDelegateMethod(QtApplication.onKeyDown, newKeyCode, event);
        } else {
            return super.onKeyDown(newKeyCode, event);
        }
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        int newKeyCode = keyCode;
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            newKeyCode = KeyEvent.KEYCODE_MEDIA_PREVIOUS;
        }

        if (QtApplication.m_delegateObject != null && QtApplication.onKeyMultiple != null) {
            return (Boolean)QtApplication
                    .invokeDelegateMethod(QtApplication.onKeyMultiple, newKeyCode, repeatCount, event);
        } else {
            return super.onKeyMultiple(newKeyCode, repeatCount, event);
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        int newKeyCode = keyCode;
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            newKeyCode = KeyEvent.KEYCODE_MEDIA_PREVIOUS;
        }

        if (QtApplication.m_delegateObject != null  && QtApplication.onKeyDown != null) {
            return (Boolean)QtApplication
                    .invokeDelegateMethod(QtApplication.onKeyUp, newKeyCode, event);
        } else {
            return super.onKeyUp(newKeyCode, event);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!hasFocus) {
            int newKeyCode = KeyEvent.KEYCODE_MEDIA_NEXT;
            KeyEvent event = new KeyEvent(KeyEvent.ACTION_DOWN, newKeyCode);

            if (QtApplication.m_delegateObject != null  && QtApplication.onKeyDown != null) {
                QtApplication.invokeDelegateMethod(QtApplication.onKeyDown, newKeyCode, event);
            } else {
                onKeyDown(newKeyCode, event);
            }
        }
    }
}
