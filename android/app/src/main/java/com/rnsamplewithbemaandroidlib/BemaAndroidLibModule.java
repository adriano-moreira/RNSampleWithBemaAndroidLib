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

    private synchronized Printer getPrinter() {
        if (printer == null) {
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

    @ReactMethod
    public void cortarParcial(Promise promise) {
        try {
            int result = printer.CortarParcial();
            promise.resolve(result);
        } catch (Exception ex) {
            promise.reject(ex);
        }
    }


    @ReactMethod
    public void cortarTotal(Promise promise) {
        try {
            int result = printer.CortarTotal();
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void ativarTextoDestaque(Promise promise) {
        try {
            int result = printer.AtivarTextoDestaque();
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void desativarTextoDestaque(Promise promise) {
        try {
            int result = printer.DesativarTextoDestaque();
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void ativarTextoItalico(Promise promise) {
        try {
            int result = printer.AtivarTextoItalico();
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void desativarTextoItalico(Promise promise) {
        try {
            int result = printer.DesativarTextoItalico();
            promise.resolve(result);
        } catch (Exception ex) {
            promise.reject(ex);
        }
    }

    @ReactMethod
    public void imprimirTextoSublinhado(String texto, Promise promise) {
        try {
            int result = printer.ImprimirTextoSublinhado(texto);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void ativarTextoUnderline(int act, Promise promise) {
        try {
            int result = printer.AtivarTextoUnderline(act);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void ativarTextoCondensado(Promise promise) {
        try {
            int result = printer.AtivarTextoCondensado();
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void desativarTextoCondensado(Promise promise) {
        try {
            int result = printer.DesativarTextoCondensado();
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void ativarTextoExpandido(int act, Promise promise) {
        try {
            int result = printer.AtivarTextoExpandido(act);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void imprimirTextoDuplo(String texto, Promise promise) {
        try {
            int result = printer.ImprimirTextoDuplo(texto);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void ativarTextoDuplo(int act, Promise promise) {
        try {
            int result = printer.AtivarTextoDuplo(act);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void alinharTexto(int act, Promise promise) {
        try {
            int result = printer.AlinharTexto(act);
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void abrirGaveta(Promise promise) {
        try {
            int result = printer.AbrirGaveta();
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void printUserConfiguration(Promise promise) {
        try {
            int result = printer.PrintUserConfiguration();
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPrinterStatusCode(Promise promise) {
        try {
            int result = printer.GetPrinterStatusCode();
            promise.resolve(result);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

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
