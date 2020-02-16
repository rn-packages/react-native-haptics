import * as React from 'react'
import { StyleSheet, View, Button } from 'react-native'
import Haptics, { HapticsType } from 'react-native-haptics'

export default function App() {
  const trigger = () => {
    Haptics.trigger(HapticsType.impactHeavy)
  }

  return (
    <View style={styles.container}>
      <Button title={'Test'} onPress={trigger} />
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
})
