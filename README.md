# react-native-haptics

> Cross platform React Native Haptics using native Android and iOS haptic functionality

## 🚀 Getting started

Minimum requirements

* iOS 10+
* Android API 16+
* React Native 0.60+

This library creates a bridge of the following native modules

* [iOS](https://developer.apple.com/design/human-interface-guidelines/ios/user-interaction/haptics/)
* [Android](https://material.io/design/platform-guidance/android-haptics.html)

### 💽 Installing

```sh
NPM
npm install react-native-haptics

Yarn
yarn add react-native-haptics
```

#### 🍏 iOS

***⚠️⚠️⚠️This package is written in Swift and targets devices using iOS 10 and above. Because this is written in swift, you will need to have a swift bridging header present in your iOS project.⚠️⚠️⚠️***

#### 🤖 Android

***No additional steps needed***


## 👨‍💻 Usage

Selection
```typescript
import Haptics, {HapticsType} from 'react-native-haptics';
Haptics.trigger(HapticsType.selection);
```

Impact Light
```typescript
import Haptics, {HapticsType} from 'react-native-haptics';
Haptics.trigger(HapticsType.impactLight);
```

Impact medium
```typescript
import Haptics, {HapticsType} from 'react-native-haptics';
Haptics.trigger(HapticsType.impactLight);
```

Impact Heavy
```typescript
import Haptics, {HapticsType} from 'react-native-haptics';
Haptics.trigger(HapticsType.impactHeavy);
```

Notification Success
```typescript
import Haptics, {HapticsType} from 'react-native-haptics';
Haptics.trigger(HapticsType.notificationSuccess);
```

Notification Warning
```typescript
import Haptics, {HapticsType} from 'react-native-haptics';
Haptics.trigger(HapticsType.notificationWarning);
```

Notification Error
```typescript
import Haptics, {HapticsType} from 'react-native-haptics';
Haptics.trigger(HapticsType.notificationError);
```

## 📱👈 Haptic types

Through the constant ``` HapticsType ``` we provide different types of haptics. You can read more about the different types and how they should be used.

| Haptics Type        	|                                                                                                                                 Usage                                                                                                                                	|
|---------------------	|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:	|
| selection           	| Selection. Indicates that the selection is actively changing. For example, the user feels light taps while scrolling a picker wheel. This feedback is intended for communicating movement through a series of discrete values, not making or confirming a selection. 	|
| impactLight         	| Light. Provides a physical metaphor that complements the visual experience. For example, people might feel a thud when a view slides into place or two objects collide.                                                                                               |
| impactMedium        	| Medium. Provides a physical metaphor that complements the visual experience. For example, people might feel a thud when a view slides into place or two objects collide.                                               	                  	                  	    |
| impactHeavy         	| Heavy. Provides a physical metaphor that complements the visual experience. For example, people might feel a thud when a view slides into place or two objects collide.                                                                                              	|
| notificationSuccess 	| Success. Indicates that a task or action, such as depositing a check or unlocking a vehicle, has completed.                                                                                                                                                          	|
| notificationWarning 	| Warning. Indicates that a task or action, such as depositing a check or unlocking a vehicle, has produced a warning of some kind.                                                                                                                                    	|
| notificationError   	| Failure. Indicates that a task or action, such as depositing a check or unlocking a vehicle, has failed.                                                                                                                                                             	|

[Read more about haptic types](https://developer.apple.com/design/human-interface-guidelines/ios/user-interaction/haptics/)

## 📝 License

MIT
