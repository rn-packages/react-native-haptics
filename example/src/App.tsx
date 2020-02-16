import * as React from 'react';
import { StyleSheet, View, Text } from 'react-native';
import Haptics from 'react-native-haptics';

export default function App() {
  const [deviceName, setDeviceName] = React.useState('');

  React.useEffect(() => {
    Haptics.getDeviceName().then(setDeviceName);
  }, []);

  return (
    <View style={styles.container}>
      <Text>Device name: {deviceName}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
