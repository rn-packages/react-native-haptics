import * as React from 'react'
import { StyleSheet, View, ScrollView } from 'react-native'
import Haptics, { HapticsType } from 'react-native-haptics'
import TextButton from './TextButton'

export default function App() {
  const trigger = (type: HapticsType) => {
    Haptics.trigger(type)
  }

  return (
    <View style={styles.container}>
      <ScrollView style={styles.scrollView}>
        <TextButton title={'Selection'} onPress={() => trigger(HapticsType.selection)} />
        <TextButton title={'Impact light'} onPress={() => trigger(HapticsType.impactLight)} />
        <TextButton title={'Impact medium'} onPress={() => trigger(HapticsType.impactMedium)} />
        <TextButton title={'Impact heavy'} onPress={() => trigger(HapticsType.impactHeavy)} />
        <TextButton title={'Notification success'} onPress={() => trigger(HapticsType.notificationSuccess)} />
        <TextButton title={'Notification warning'} onPress={() => trigger(HapticsType.notificationWarning)} />
        <TextButton title={'Notification error'} onPress={() => trigger(HapticsType.notificationError)} />
      </ScrollView>
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  scrollView: {
    flex: 1,
    top: 50,
  },
})
