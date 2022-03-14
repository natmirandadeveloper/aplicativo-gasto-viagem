package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }

    }

    private fun calculate() {

        if (validationOK()) {
            try{
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy
                textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
            }catch (nfe: NumberFormatException){
                Toast.makeText(this, getString(R.string.preenche_todos_os_campos), Toast.LENGTH_LONG).show()
            }
        }else {
            Toast.makeText(this, getString(R.string.preenche_todos_os_campos), Toast.LENGTH_LONG).show()
        }

    }

    private fun validationOK(): Boolean {
        return (editDistance.text.toString() != ""
                && editPrice.text.toString() != ""
                && editAutonomy.text.toString() != "")
    }
}