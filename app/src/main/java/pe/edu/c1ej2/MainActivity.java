package pe.edu.c1ej2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//diferencia xml que un java
    EditText num1, num2;
    EditText result = findViewById(R.id.edtresult);
    double factorial=1;
    Button btnCalcular;
    Spinner spOperacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //logica de programacion en activity_main
        //Primero Referncilos objetos- views con los que se interactua
        num1=findViewById(R.id.edtn1);
        num2=findViewById(R.id.edtn2);
        spOperacion=findViewById(R.id.spOperacion);
        btnCalcular=findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);//alt+enter
    }

    @Override
    public void onClick(View view) {
        String mostrar=result.getText().toString();
        double n1= Double.parseDouble(num1.getText().toString());
        double n2 = Double.parseDouble(num2.getText().toString());
        String operacion=spOperacion.getSelectedItem().toString();
        double resultado=0;
        if (operacion.equals("+")) resultado=n1+n2;
        if (operacion.equals("-")) resultado=n1-n2;
        if (operacion.equals("x")) resultado=n1*n2;
        if (operacion.equals("/")) resultado=n1/n2;
        // agregar lo necesario para tener las operaciones de ^ Potencia, factorial(sólo del primer número) y resto de la division
        // potencia
        if (operacion.equals("^")) resultado=Math.pow(n1,n2);
        //raiz
        if (operacion.equals("r")) resultado=Math.pow(n1,1/n2);
        //factoria
        if (operacion.equals("!")){
            for (int i=1;i<=n1;i++){
                factorial=factorial*i;
            }
            resultado=factorial;
        }
        //Resto
        if (operacion.equals("%")) resultado=n1%n2;
        // raiz n (Primer numero base, segundo numero la raiz
        // Utilizar la libreria Math.
        // Entregar al aula virtual en un video debe mostrar la lógica utiizada (Mainactivity ) y las pruebas con los operadores nuevos
        // Plazo hoy a las 11:59 pm.
        // el video lo subes al drive y al aula unicamente el link de compartición


        Toast.makeText(this, "El resultado es " + resultado , Toast.LENGTH_SHORT).show();
        factorial=1;
    }
}
