import React, { FunctionComponent } from 'react'
import { StyleSheet, View, Button } from 'react-native'

type Props = {
  title: string
  onPress: () => void
}

const styles = StyleSheet.create({
  buttonView: {
    width: 200,
    height: 60,
    borderRadius: 30,
    marginBottom: 30,
    justifyContent: 'center',
    backgroundColor: '#eba134',
  },
  button: {
    color: 'white',
  },
})

const TextButton: FunctionComponent<Props> = ({ title, onPress }) => (
  <View style={styles.buttonView}>
    <Button title={title} color={styles.button.color} onPress={onPress} />
  </View>
)

export default TextButton
