package com.reactnativehaptics

import android.os.Build
import android.view.HapticFeedbackConstants
import com.facebook.react.bridge.LifecycleEventListener
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.reactnativehaptics.HapticsType.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * React Native Haptics
 * @author Jason Kelly <jason-kelly@live.dk>
 *
 * The goal with this module
 * is to provide a binding of androids
 * newly added haptics possibilities
 *
 * This is much like the iOS counterpart
 * where special hardware is embedded into
 * the different devices. Instead of using
 * the normal system vibrator service we instead
 * use the normally view bound ```performHaptics```
 *
 * we achieve it by selecting the root view
 * and performing the haptics on that.
 *
 * This is not the correct semantic way to go
 * but it will allow us to have a very concise
 * API that provides
 */
class HapticsModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
  private val scope = MainScope()

  init {
    reactContext.addLifecycleEventListener(object : LifecycleEventListener {
      override fun onHostResume() {}

      override fun onHostPause() {}

      override fun onHostDestroy() {
        scope.cancel()
      }
    })
  }

  /**
   * This is aligned with the iOS implementation
   * @return String name of package
   */
  override fun getName(): String = "Haptics"

  /**
   * Gets the options for
   * the trigger method in React Native
   * @return
   */
  override fun getConstants(): MutableMap<String, Any> {
    return values().map { Pair(it.toString(), it.toString()) }.toMap().toMutableMap()
  }

  /**
   * This method utilises the decorView to
   * trigger the otherwise view bound haptic
   * engine on android phones that supports it.
   *
   * @param type HapticsType
   */
  @ReactMethod
  fun trigger(type: String) {
    // Get the root window which is a view
    val rootView = currentActivity?.window?.decorView
        ?: throw IllegalStateException("Haptics was triggered without the activity window initialized. You should only call haptics when the application is in foreground!")
    rootView.isHapticFeedbackEnabled = true

    val shouldIgnoreGlobalSettings = true

    val feedbackFlag = when (shouldIgnoreGlobalSettings) {
      true -> HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING
      else -> HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING
    }

    when (type) {
      SELECTION.toString() -> {
        rootView.performHapticFeedback(
            HapticFeedbackConstants.VIRTUAL_KEY, feedbackFlag)
      }
      IMPACT_HEAVY.toString() -> {
        rootView.performHapticFeedback(
            HapticFeedbackConstants.LONG_PRESS, feedbackFlag)
      }
      IMPACT_LIGHT.toString() -> {
        rootView.performHapticFeedback(
            HapticFeedbackConstants.VIRTUAL_KEY, feedbackFlag)
      }
      IMPACT_MEDIUM.toString() -> {
        // Handle old versions of Android
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
          rootView.performHapticFeedback(
              HapticFeedbackConstants.KEYBOARD_PRESS, feedbackFlag)
        }
      }
      NOTIFICATION_ERROR.toString() -> {
        scope.launch {
          rootView.performHapticFeedback(
              HapticFeedbackConstants.LONG_PRESS, feedbackFlag)

          delay(200)

          rootView.performHapticFeedback(
              HapticFeedbackConstants.LONG_PRESS, feedbackFlag)

          delay(300)

          rootView.performHapticFeedback(
              HapticFeedbackConstants.LONG_PRESS, feedbackFlag)

          delay(400)

          rootView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY, feedbackFlag)
        }
      }
      NOTIFICATION_SUCCESS.toString() -> {
        scope.launch {
          rootView.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, feedbackFlag)

          delay(200)

          rootView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY, feedbackFlag
          )
        }
      }
      NOTIFICATION_WARNING.toString() -> {
        scope.launch {
          rootView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY, feedbackFlag)

          delay(200)

          rootView.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, feedbackFlag)
        }
      }
    }
  }
}
