package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Scanner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener() {
            val weight = txtWeight.text.toString().toDouble()
            val height = txtHeight.text.toString().toDouble()

            val bmi = calculateBMI(height, weight)
            val status:String

            if(bmi < 18.5){
                status = "Under"
                imageView.setImageResource(R.drawable.under)}
            else if (bmi <= 24.9){
                status = "Normal"
                imageView.setImageResource(R.drawable.normal)}
            else{
                status = "Over"
                imageView.setImageResource(R.drawable.over)}
            txtResult.text = "BMI : %.2f(%s)".format(bmi,status)
        }

        btnReset.setOnClickListener(){
            imageView.setImageResource((R.drawable.empty))

            txtHeight.text = null
            txtResult.text = null
            txtWeight.text = null
            txtWeight.requestFocus()
        }
    }


    public fun calculateBMI(height:Double,weight:Double):Double{
        return weight/ (height * height)
    }
    // private fun calculateBMI(bmiValue:Double) {
    //val bmiValue:Double
    //val input:String = txtWeight.text.toString()
    //  val input2:String = txtHeight.text.toString()
    //val weight:Double = input.toDouble()
    // val height:Double = input2.toDouble()

    // bmiValue = weight / (height*2)

    // txtResult.text = "0.2f".format(bmiValue)

    //}


}

