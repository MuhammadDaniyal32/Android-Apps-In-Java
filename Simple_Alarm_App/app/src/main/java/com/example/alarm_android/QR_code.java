package com.example.alarm_android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class QR_code extends AppCompatActivity {
    ImageView imageView;
    Button button;
    Button btnScan;
    EditText editText;
    String EditTextValue ;
    Thread thread ;
    public final static int QRcodeWidth = 350;
    Bitmap bitmap ;
    TextView tv_qr_readTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r_code);
        imageView = (ImageView) findViewById(R.id.imageView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        // btnScan = (Button)findViewById(R.id.btnScan);
        tv_qr_readTxt = (TextView) findViewById(R.id.tv_qr_readTxt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText.getText().toString().isEmpty()) {
                    EditTextValue = editText.getText().toString();

                    try {
                        bitmap = TextToImageEncode(EditTextValue);

                        imageView.setImageBitmap(bitmap);

                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                } else {
                    editText.requestFocus();
                    Toast.makeText(QR_code.this, "Please Enter Your Scanned Test", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
        Bitmap TextToImageEncode(String Value) throws WriterException
        {
            BitMatrix bitMatrix;
            try
            {
                bitMatrix = new MultiFormatWriter().encode(
                        Value,
                        BarcodeFormat.DATA_MATRIX.QR_CODE,
                        QRcodeWidth, QRcodeWidth, null
                );
            }
            catch (IllegalArgumentException Illegalargumentexception)
            {

                return null;
            }

            int bitMatrixWidth = bitMatrix.getWidth();
            int bitMatrixHeight = bitMatrix.getHeight();
            int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

            for (int y = 0; y < bitMatrixHeight; y++)
            {
                int offset = y * bitMatrixWidth;
                for (int x = 0; x < bitMatrixWidth; x++)
                {

                    pixels[offset + x] = bitMatrix.get(x, y) ?
                            getResources().getColor(R.color.QRCodeBlackColor):getResources().getColor(R.color.QRCodeWhiteColor);
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

            bitmap.setPixels(pixels, 0, 350, 0, 0, bitMatrixWidth, bitMatrixHeight);
            return bitmap;
        }
    }