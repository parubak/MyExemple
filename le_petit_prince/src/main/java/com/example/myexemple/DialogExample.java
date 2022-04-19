package com.example.myexemple;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DialogExample extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
    }
    public void onCloseButtonClick(View view){
        String[] arrIngridients={"Apple","Nats","Jem"};
        final boolean[] arrSelectedIngredients={true,false,true};

        AlertDialog.Builder builder=new AlertDialog.Builder(DialogExample.this);
        builder.setTitle("Exit program")
                .setIcon(R.drawable.ic_launcher_background)
//                .setMessage("What?") //Message
                //установить элементы множественного выбора
                .setMultiChoiceItems(arrIngridients,null,(dialog, which
                        , isChecked) -> {
                    arrSelectedIngredients[which]=isChecked;
                })
                .setCancelable(false) //невозможность закрытия окна о
                .setPositiveButton("Yes!", (dialog, id) ->finish()
                )
        .setNegativeButton("No!", (dialog, which) -> dialog.cancel());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
