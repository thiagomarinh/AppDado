package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            rollDice()
        }

        rollDice()
    }

    /**
     * Jogue os dados e atualize a tela com o resultado.
     */
    private fun rollDice() {
        // Crie um novo objeto Dice com 6 lados e rola os dados
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Encontra o ImageView no layout pelo id e atribui a varivael do tipo ImageView diceImage
        val diceImage: ImageView = findViewById(R.id.imageView)

        //Determine qual ID de recurso desenhável usar com base na rolagem de dados
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Atualize o ImageView com a imagem do dado
        diceImage.setImageResource(drawableResource)

        //// Atualiza a descrição do conteúdo
        diceImage.contentDescription = diceRoll.toString()
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
