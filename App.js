import React, {useState} from 'react';
import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
  Button,
} from 'react-native';

import {
  Header,
  Colors,
} from 'react-native/Libraries/NewAppScreen';

import BemaAndroidLib from './BemaAndroidLib'

const App: () => React$Node = () => {

  const [printerState, setPrinertState] = useState('');

  const syncPrint = () => {
    BemaAndroidLib.findPrinter()
      .catch(err => console.log({err}));
    BemaAndroidLib.getPrinterStatus()
      .then(status => setPrinertState(status))
      .catch(err => console.log({err}));
  }
  const site = 'https://codengage.com'
  
  const printText = () => {
    BemaAndroidLib.imprimirTexto(site).catch(err => console.log({err}))
  }

  const printQRCode = async () => {
    return BemaAndroidLib.imprimirQRCode(site).catch(err => console.log({err}))
  }

  return (
    <>
      <StatusBar barStyle="dark-content" />
      <SafeAreaView>
        <ScrollView
          contentInsetAdjustmentBehavior="automatic"
          style={styles.scrollView}>
          <View style={styles.body}>
            <Button title='Sync Printer' onPress={syncPrint}></Button>
            <Text>
              Status: {printerState}
            </Text>
            <Button title='print text' onPress={printText}></Button>
            <Button title='print qrcode' onPress={printQRCode}></Button>
          </View>
        </ScrollView>
      </SafeAreaView>
    </>
  );
};

const styles = StyleSheet.create({
  scrollView: {
    backgroundColor: Colors.lighter,
  },
  engine: {
    position: 'absolute',
    right: 0,
  },
  body: {
    backgroundColor: Colors.white,
  },
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
    color: Colors.black,
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
    color: Colors.dark,
  },
  highlight: {
    fontWeight: '700',
  },
  footer: {
    color: Colors.dark,
    fontSize: 12,
    fontWeight: '600',
    padding: 4,
    paddingRight: 12,
    textAlign: 'right',
  },
});

export default App;
