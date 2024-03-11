package com.example.calculadora

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initListeners()
    }

    fun initListeners(){

        binding.buttonCalcular.setOnClickListener {
            var resultado = when (binding.radioGroup.checkedRadioButtonId){
                binding.radioButtonAdicao.id -> adicao()
                binding.radioButtonSubtracao.id -> subtracao()
                binding.radioButtonMultiplicacao.id -> multiplicacao()
                binding.radioButtonDivisao.id -> divisao()
                else -> Toast.makeText(this, "Selecione uma opcao", Toast.LENGTH_SHORT).show()
            }
        }

        binding.radioGroup.setOnCheckedChangeListener { _, _ ->
            binding.textViewResultado.text = "Resultado: "
            binding.editTextValor1.setText("0.0")
            binding.editTextValor2.setText("0.0")
        }
    }

    fun adicao(){
        var resultado = binding.editTextValor1.text.toString().toFloat() + binding.editTextValor2.text.toString().toFloat()

        binding.textViewResultado.text = resultado.toString()
    }

    fun subtracao(){
        var resultado = binding.editTextValor1.text.toString().toFloat() - binding.editTextValor2.text.toString().toFloat()

        binding.textViewResultado.text = resultado.toString()
    }

    fun multiplicacao(){
        var resultado = binding.editTextValor1.text.toString().toFloat() * binding.editTextValor2.text.toString().toFloat()

        binding.textViewResultado.text = resultado.toString()
    }

    fun divisao(){
        if (binding.editTextValor2.text.toString().toFloat() == 0.0.toFloat()){
            Toast.makeText(this, "O segundo valor nao pode ser 0.0", Toast.LENGTH_SHORT).show()
        } else {
            var resultado = binding.editTextValor1.text.toString().toFloat() / binding.editTextValor2.text.toString().toFloat()

            binding.textViewResultado.text = resultado.toString()
        }
    }

}