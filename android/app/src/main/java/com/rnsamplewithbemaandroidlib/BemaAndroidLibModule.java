package com.rnsamplewithbemaandroidlib;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import br.com.bematech.android.usb.mp4200th.Printer;

public class BemaAndroidLibModule extends ReactContextBaseJavaModule {

    public BemaAndroidLibModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return "BemaAndroidLib";
    }

    private Printer printer;

    private synchronized Printer getPrinter(){
        if(printer == null){
            printer = new Printer();
        }
        return printer;
    }

    @ReactMethod
    public void findPrinter(Promise promise) {
        try {
            getPrinter().FindPrinter();
            promise.resolve(null);
        } catch (Exception ex) {
            promise.reject(ex);
        }
    }

    @ReactMethod
    public void imprimirTexto(String texto, Promise promise) {
        try {
            int result = getPrinter().ImprimirTexto(texto);
            promise.resolve(result);
        } catch (Exception ex) {
            promise.reject(ex);
        }

    }

    @ReactMethod
    public void imprimirQRCode(String url, Promise promise) {
        try {
            int result = getPrinter().ImprimirQRCode(url);
            promise.resolve(result);
        } catch (Exception ex) {
            promise.reject(ex);
        }
    }

    //    @ReactMethod
//    public int CortarParcial() {
//        return printer.CortarParcial();
//    }
//
//    @ReactMethod
//    public int CortarTotal() {
//        return printer.CortarTotal();
//    }
//
//    @ReactMethod
//    public int AtivarTextoDestaque() {
//        return printer.AtivarTextoDestaque();
//    }
//
//    @ReactMethod
//    public int DesativarTextoDestaque() {
//        return printer.DesativarTextoDestaque();
//    }
//
//    @ReactMethod
//    public int AtivarTextoItalico() {
//        return printer.AtivarTextoItalico();
//    }
//
//    @ReactMethod
//    public int DesativarTextoItalico() {
//        return printer.DesativarTextoItalico();
//    }
//
//    @ReactMethod
//    public int ImprimirTextoSublinhado(String texto) {
//        return printer.ImprimirTextoSublinhado(texto);
//    }
//
//    @ReactMethod
//    public int AtivarTextoUnderline(int act) {
//        return printer.AtivarTextoUnderline(act);
//    }
//
//    @ReactMethod
//    public int AtivarTextoCondensado() {
//        return printer.AtivarTextoCondensado();
//    }
//
//    @ReactMethod
//    public int DesativarTextoCondensado() {
//        return printer.DesativarTextoCondensado();
//    }
//
//    @ReactMethod
//    public int AtivarTextoExpandido(int act) {
//        return printer.AtivarTextoExpandido(act);
//    }
//
//    @ReactMethod
//    public int ImprimirTextoDuplo(String texto) {
//        return printer.ImprimirTextoDuplo(texto);
//    }
//
//    @ReactMethod
//    public int AtivarTextoDuplo(int act) {
//        return printer.AtivarTextoDuplo(act);
//    }
//
//    @ReactMethod
//    public int AlinharTexto(int act) {
//        return printer.AlinharTexto(act);
//    }
//
//    @ReactMethod
//    public int AbrirGaveta() {
//        return printer.AbrirGaveta();
//    }
//
//    @ReactMethod
//    public int PrintUserConfiguration() {
//        return printer.PrintUserConfiguration();
//    }
//
//    @ReactMethod
//    public int GetPrinterStatusCode() {
//        return printer.GetPrinterStatusCode();
//    }
//
    @ReactMethod
    public void getPrinterStatus(Promise promise) {
        try {
            String printerStatus = getPrinter().GetPrinterStatus();
            promise.resolve(printerStatus);
        } catch (Exception ex) {
            promise.reject(ex);
        }
    }
}
