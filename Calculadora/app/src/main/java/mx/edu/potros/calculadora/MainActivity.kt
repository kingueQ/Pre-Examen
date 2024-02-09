package mx.edu.potros.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val res: TextView = findViewById(R.id.result)
        val num: TextView = findViewById(R.id.number)
        val error : TextView = findViewById(R.id.error)
        val num1 : Button = findViewById(R.id.btn1)
        val num2 : Button = findViewById(R.id.btn2)
        val num3 : Button = findViewById(R.id.btn3)
        val num4 : Button = findViewById(R.id.btn4)
        val num5 : Button = findViewById(R.id.btn5)
        val num6 : Button = findViewById(R.id.btn6)
        val num7 : Button = findViewById(R.id.btn7)
        val num8 : Button = findViewById(R.id.btn8)
        val num9 : Button = findViewById(R.id.btn9)
        val C : Button = findViewById(R.id.btnC)
        val igual : Button = findViewById(R.id.btnIgual)
        val mas : Button = findViewById(R.id.btnMas)
        val menos : Button = findViewById(R.id.btnMenos)
        val por : Button = findViewById(R.id.btnPor)
        val entre : Button = findViewById(R.id.btnEntre)
        val num0 : Button = findViewById(R.id.btn0)
        var resultado : Double=0.0
        var numero : Double=0.0
        var operacion : Int = 0
        var ya = false;

        num1.setOnClickListener() {
            num.setText(num.text.toString()+'1')
        }

        num2.setOnClickListener() {
            num.setText(num.text.toString()+'2')
        }

        num3.setOnClickListener() {
            num.setText(num.text.toString()+'3')
        }

        num4.setOnClickListener() {
            num.setText(num.text.toString()+'4')
        }

        num5.setOnClickListener() {
            num.setText(num.text.toString()+'5')
        }

        num6.setOnClickListener() {
            num.setText(num.text.toString()+'6')
        }

        num7.setOnClickListener() {
            num.setText(num.text.toString()+'7')
        }

        num8.setOnClickListener() {
            num.setText(num.text.toString()+'8')
        }

        num9.setOnClickListener() {
            num.setText(num.text.toString()+'9')
        }

        num0.setOnClickListener() {
            num.setText(num.text.toString()+'0')
        }

        mas.setOnClickListener() {
            numero = num.text.toString().toDouble()
            if(numero!=0.0){
                res.setText(numero.toString()+'+')
                num.setText("0")
                operacion = 1
            }else if(resultado!=0.0){
                res.setText(resultado.toString()+'+')
                num.setText("0")
                operacion=1
            }
        }

        menos.setOnClickListener() {
            numero = num.text.toString().toDouble()
            if(numero!=0.0){
                res.setText(numero.toString()+'-')
                num.setText("0")
                operacion = 2
            }else if(resultado!=0.0){
                res.setText(resultado.toString()+'-')
                num.setText("0")
                operacion=2
            }
        }

        por.setOnClickListener() {
            if(num.text.toString().length !=0){
                numero = num.text.toString().toDouble()
                if(numero!=0.0){
                    res.setText(numero.toString()+'*')
                    num.setText("0")
                    operacion = 3
                }else if(resultado!=0.0){
                    res.setText(resultado.toString()+'*')
                    num.setText("0")
                    operacion=3
                }
            }
        }

        entre.setOnClickListener() {
            if(num.text.toString().length !=0){
                numero = num.text.toString().toDouble()
                if(numero!=0.0){
                    res.setText(numero.toString()+'/')
                    num.setText("0")
                    operacion = 4
                }else if(resultado!=0.0){
                    res.setText(resultado.toString()+'/')
                    num.setText("0")
                    operacion=4
                }
            }
        }

        igual.setOnClickListener() {
            if (num.text.toString().isNotEmpty()) {
                if (operacion == 0) {
                    error.setText("No se eligió ninguna operación")
                } else if (operacion == 4 && num.text.toString().toDoubleOrNull() == 0.0) {
                    error.setText("No se puede dividir entre 0")
                    resultado = 0.0
                    numero = 0.0
                    res.setText("")
                    num.setText("")
                } else {
                    if (numero != 0.0) {
                        resultado = numero
                    }
                    numero = num.text.toString().toDoubleOrNull() ?: 0.0
                    resultado = operacion(resultado, numero, operacion)
                    res.setText(resultado.toString())
                    num.setText("0")
                    numero=0.0
                    operacion = 0
                }
            }
        }

        C.setOnClickListener() {
            resultado=0.0
            numero=0.0
            res.setText("")
            num.setText("")
            error.setText("")
        }

    }

    fun operacion(numero1: Double, numero2: Double, operacion: Int) : Double{
        if(operacion==1){
            return numero1 + numero2
        }else if(operacion==2){
            return numero1 - numero2
        }else if(operacion==3){
            return numero1 * numero2
        }else if(operacion==4){
            return numero1 / numero2
        }else{
            return 0.0
        }
    }
}