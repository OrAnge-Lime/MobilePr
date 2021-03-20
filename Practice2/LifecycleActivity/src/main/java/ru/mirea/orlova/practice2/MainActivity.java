package ru.mirea.orlova.practice2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    //производится первоначальная настройка activity, создаются объекты визуального интерфейса. Метод получает
    //объект Bundle, который содержит прежнее состояние activity. Если activity заново создается, то данный объект имеет значение null.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onStart()");
    }

    @Override
    /*осуществляется подготовка к выводу activity на экран. Этот метод не требует переопределения, а всю работу производит встроенный код.
    По завершению activity отображается на экране*/
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onCreate()");
    }

    @Override
    //восстанавливает сохраненное состояние из объекта Bundle
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState()");
    }

    @Override
    //Используется для специальных действий, которые должны выполняться только при
    //повторном запуске активности в рамках «полноценного» состояния (Если окно возвращается в приоритетный режим после вызова onStop())
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    @Override
    /*activity переходит в состояние Resumed, а пользователь может с ней взаимодействовать.
    Activity остается в этом состоянии, пока она не потеряет фокус*/
    protected void onResume() {
        super. onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    /*Вызывается если пользователь решит перейти к другую activity. В этом методе возможно освобождать используемые ресурсы,
    приостанавливать процессы, чтобы они меньше сказывались на производительности системы*/
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    //производится сохранение состояния приложения
    //в передаваемый в качестве параметра объект Bundle
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
   /* Activity переходит в состояние Stopped. В onStop следует
    освобождать используемые ресурсы, которые не требуются пользователю, когда он
    не взаимодействует с activity. Здесь также возможно сохранять данные, например,
    в базу данных. При этом во время состояния Stopped activity остается в памяти
    устройства, сохраняется состояние всех элементов интерфейса*/
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    //Завершается работа Activity
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }
}