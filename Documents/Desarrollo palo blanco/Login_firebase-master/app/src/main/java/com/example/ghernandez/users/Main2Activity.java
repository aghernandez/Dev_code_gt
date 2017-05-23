package com.example.ghernandez.users;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.R.attr.name;

public class Main2Activity extends AppCompatActivity {

    private EditText nombre;
    private EditText mail;
    private EditText lTrabajo;
    private EditText domicilio;
    private EditText telefono;
    private EditText obser;
    private FloatingActionButton btnEnviar;


    DatabaseReference dbConec = FirebaseDatabase.getInstance().getReference();
    DatabaseReference refb = dbConec.child("persona");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




         btnEnviar = (FloatingActionButton) findViewById(R.id.floatingActionButton);
         nombre =(EditText)findViewById(R.id.editText);
         mail = (EditText)findViewById(R.id.editText2);
         lTrabajo = (EditText)findViewById(R.id.editText3);
         domicilio = (EditText)findViewById(R.id.editText4);
         telefono = (EditText)findViewById(R.id.editText5);
         obser = (EditText)findViewById(R.id.editText6);




        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String cnombre = nombre.getText().toString();
                nombre.setText("");
                String cmail = mail.getText().toString();
                mail.setText("");
                String ctrabajo = lTrabajo.getText().toString();
                lTrabajo.setText("");
                String cdomicilio = domicilio.getText().toString();
                domicilio.setText("");
                String ctelefono = telefono.getText().toString();
                telefono.setText("");
                String cobservaciones =obser.getText().toString();
                obser.setText("");


                persona user = new persona(cnombre,cmail,ctrabajo,cdomicilio,ctelefono,cobservaciones);
                refb.push().setValue(user);

            }

        });

    }


}
