import React, {useState} from 'react';
import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
  Button,
  ToastAndroid,
} from 'react-native';

import {
  Header,
  Colors,
} from 'react-native/Libraries/NewAppScreen'

import BemaAndroidLib from './BemaAndroidLib'

const App: () => React$Node = () => {

  const [printerState, setPrinertState] = useState('')

  const site = 'https://codengage.com'
 
  const showSuccess = (msg) => ToastAndroid.show(msg, ToastAndroid.SHORT)
  const showError = (e) => {
    console.error(e)
    ToastAndroid.show('error:' + e.message, ToastAndroid.LONG)
  };

  const syncPrint = async () => {
   try {
    await BemaAndroidLib.findPrinter();
    const state = await BemaAndroidLib.getPrinterStatus()
    setPrinertState(state) 
    showSuccess(`status: ${status}`)
   } catch {
     showError(e)
   }
  }

  const printText = async () => {
    try {
     await BemaAndroidLib.imprimirTexto(site)
     await BemaAndroidLib.cortarTotal()
     showSuccess("texto impresso!")
    } catch (e) {
      showError(e)
    }
  }

  const printQRCode = async () => {
   try {
     await BemaAndroidLib.imprimirQRCode(site)
     await BemaAndroidLib.cortarTotal()
     showSuccess("qrcode impresso!")
   } catch {
      showError(e)
   }
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
