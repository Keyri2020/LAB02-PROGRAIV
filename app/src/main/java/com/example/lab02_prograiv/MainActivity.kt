package com.example.lab02_prograiv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var etNombre : EditText
    private lateinit var etnEdad : EditText
    private lateinit var etDepar : EditText
    private lateinit var lvNombres : ListView
    private lateinit var tvSelect : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNombre = findViewById(R.id.et_Nombre)
        etnEdad = findViewById(R.id.etn_Edad)
        etDepar = findViewById(R.id.et_Depar)
        lvNombres = findViewById(R.id.lv_Nombres)
        tvSelect = findViewById(R.id.tv_Select)
    }

    private var nombresList = ArrayList<String>()
    private var edadesList = ArrayList<Int>()
    private var departamentosList = ArrayList<String>()

    fun agregarDatos (v:View){

        var nombre = etNombre.text.toString()
        var edad = etnEdad.text.toString().toInt()
        var depa = etDepar.text.toString()

        nombresList.add(nombre)
        edadesList.add(edad)
        departamentosList.add(depa)

        var adaptador : ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.adaptador_list_view, nombresList)
        lvNombres?.adapter = adaptador

        lvNombres?.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?,
                                     p1: View?,
                                     person: Int,
                                     p3: Long) {
                tvSelect?.setText("La persona que seleccionó es ${nombresList[person]} de ${edadesList[person]} años de edad, del departamento de ${departamentosList[person]}.")
            }

        }

        etNombre.setText("")
        etnEdad.setText("")
        etDepar.setText("")

        nombre = ""
        edad = 0
        depa = ""

    }
}