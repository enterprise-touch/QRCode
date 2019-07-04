package com.et.qrlib;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRCompiler{
    public static Bitmap generater(String text, int width, int height){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,width,height);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            return bitmap;
        }
        catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Class aClasser;
    public static Context contexter;
    public static String reader(Context context, Class aClass) {
        aClasser = aClass;
        contexter = context;
        Intent intent = new Intent(context, ScanActivity.class);
        context.startActivity(intent);
        return null;
    }

    public void result(String text){
        try {
            ResultInterface ob = (ResultInterface) aClasser.newInstance();
            ob.readerResult(text);
        } catch (InstantiationException ex) {
            Log.d("Exception : ", ""+ex.getMessage());
        } catch (IllegalAccessException ex) {
            Log.d("Exception : ", ""+ex.getMessage());
        }
    }


}
