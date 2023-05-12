package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    /**
     * Joga os dados e atualize a tela com o resultado
     */
    private fun rollDice() {
        // Cria um novo objeto Dado com 6 lados e joga
        val dice = Dice(6)
        val diceRoll = dice.roll()

        /**
         * acha o textView pelo id e atribui em a variavel resultTextView do tipo TextView, pega o
         * resultado do dado em inteiro e transforma para String, apos isso atribui para o atributo
         * text do objeto resultTextView
         */

        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        val dado = Dice(12)
        val jogarDado= dado.roll()

        val resultadoTextView: TextView = findViewById(R.id.textView2)
        resultadoTextView.text = jogarDado.toString()


    }
}

/**
 * Classe Dice com parametro para colocar o numero de lados
 */
class Dice(private val numSides: Int) {
    // função para gera um numero aleatorio de acordo com o numero de lados do parametro
    fun roll(): Int {
        return (1..numSides).random()
    }
}
