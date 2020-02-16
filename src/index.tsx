import { NativeModules } from 'react-native'
import HapticsType from './types/HapticsType'
export { HapticsType }

class Haptics {
  private readonly haptics = NativeModules.Haptics

  trigger = (type: HapticsType = HapticsType.selection) => {
    try {
      console.log('json', this.haptics)
      //  this.haptics.trigger(type);
      NativeModules.Haptics.trigger(type)
    } catch (err) {
      console.error('Haptics is not available, is the native module registered correct?')
    }
  }
}

export default new Haptics()
