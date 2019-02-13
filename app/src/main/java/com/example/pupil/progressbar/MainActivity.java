package com.example.pupil.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    ProgressBar progress;
    Button buttonOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = findViewById(R.id.progress);
        buttonOk = findViewById(R.id.buttonOK);
        progress.setMax(100);
        try {
            writeToFile(createFile(getFilesDir().getAbsolutePath()+"/Temo.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            createFile(getFilesDir().getAbsoluteFile() + "/Temp.txt");
        } catch (IOException e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private File createFile(String path) throws IOException {
        File file = new File(path);
        if (!checkFile(file)) createNewFile(file);
        return file;
    }

    private boolean checkFile(File file) {
        return file.exists();
    }

    private boolean createNewFile(File file) throws IOException {
        return file.createNewFile();
    }

    private void writeToFile(File file) {
        String str = "Hello, world!";
        byte[] mass = str.getBytes();
        ByteArrayInputStream b = new ByteArrayInputStream(mass);
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file.getAbsolutePath());
            stream.write(mass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int c = 0;
        for (; ; ) {
            if (c == -1) {
                break;
            }
            c = b.read();
            System.out.println((char) c + " " + c + "123123");
        }
    }

}
