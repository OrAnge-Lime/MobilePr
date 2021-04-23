package ru.mirea.orlova.mireaproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class CalculateFragment extends Fragment {

    public String Calculate(double a, double b, String c) {
        String res = "";
        switch (c){
            case("+"):
                res = Double.toString(a + b);
                break;
            case("-"):
                res = Double.toString(a - b);
                break;
            case("*"):
                res = Double.toString(a * b);
                break;
            case("/"):
                if (b != 0)
                    res = Double.toString(a / b);
                else
                    res =  "ERROR";
                break;
            default:
                res =  "ERROR";
        }

        return res;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calculate, container, false);

        Button Count = root.findViewById(R.id.button);
        View.OnClickListener c = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res;
                String allowdnum = "0123456789";
                String allowdsigns = "+-*/";
                TextView ex = root.findViewById(R.id.ex);
                String text = (String) ex.getText();
                boolean n = true;
                if(text.length() > 0){
                    if(allowdnum.contains(String.valueOf(text.charAt(0))) & allowdnum.contains(String.valueOf(text.charAt(text.length())))){
                        for(int i = 0; i < text.length(); i++){
                            if(!allowdnum.contains(String.valueOf(text.charAt(i))) & !allowdsigns.contains(String.valueOf(text.charAt(i)))) {
                                n = false;
                                break;
                            }
                        }
                    }
                    else
                        n = false;
                }
                else
                    n = false;

                if(n){
                    int i = 0;
                    String a = "";
                    String b = "";
                    String c;
                    while(allowdnum.contains(String.valueOf(text.charAt(i)))){
                        a += text.charAt(i);
                        i++;
                    }
                    if(i != text.length()){
                        c = String.valueOf(text.charAt(i));
                        if(!allowdsigns.contains(String.valueOf(text.charAt(i+1)))){
                            while(allowdnum.contains(String.valueOf(text.charAt(i)))){
                                b += text.charAt(i);
                                i++;
                            }
                            res = Calculate(Double.parseDouble(a), Double.parseDouble(b), c);
                        }
                        else
                            res = "ERROR";
                    }
                    else
                        res = a;
                }
                else
                    res = "ERROR";
                TextView result = root.findViewById(R.id.textView3);
                result.setText("a");
            }
        };
        Count.setOnClickListener(c);
        return root;
    }
}