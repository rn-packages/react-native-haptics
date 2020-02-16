package com.reactnativehaptics

/**
 * This defines the different types
 * of haptics that we support
 * throughout the package.
 *
 * @author Jason Kelly <jason-kelly@live.dk>
 */
enum class HapticsType(private val value: String) {
  SELECTION("selection"),
  IMPACT_LIGHT("impactLight"),
  IMPACT_MEDIUM("impactMedium"),
  IMPACT_HEAVY("impactHeavy"),
  NOTIFICATION_SUCCESS("notificationSuccess"),
  NOTIFICATION_WARNING("notificationWarning"),
  NOTIFICATION_ERROR("notificationError");

  override fun toString(): String {
    return this.value
  }
}
