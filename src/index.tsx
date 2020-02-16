import { NativeModules } from 'react-native'

type HapticsType = {
  getDeviceName(): Promise<string>
}

const { Haptics } = NativeModules

export default Haptics as HapticsType
