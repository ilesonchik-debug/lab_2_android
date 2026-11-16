package com.example.lab_2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Список изображений галереи
    private val artworks = listOf(
        R.drawable.s1,
        R.drawable.s2,
        R.drawable.s3,
        R.drawable.s4,
        R.drawable.s5
    )

    // Индекс текущего изображения
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Восстанавливаем индекс после поворота экрана
        currentIndex = savedInstanceState?.getInt("CURRENT_INDEX") ?: 0

        // Находим элементы интерфейса
        val artworkImage = findViewById<ImageView>(R.id.artworkImage)
        val artworkTitle = findViewById<TextView>(R.id.artworkTitle)
        val artworkAuthor = findViewById<TextView>(R.id.artworkAuthor)

        val previousButton = findViewById<Button>(R.id.previousButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        // Обновление отображаемой картины
        fun updateArtwork() {
            artworkImage.setImageResource(artworks[currentIndex])

            artworkTitle.text = "Произведение №${currentIndex + 1}"
            artworkAuthor.text = "Автор неизвестен"

            previousButton.isEnabled = currentIndex > 0
            nextButton.isEnabled = currentIndex < artworks.lastIndex
        }

        // Переход к предыдущей картине
        previousButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateArtwork()
            }
        }

        // Переход к следующей картине
        nextButton.setOnClickListener {
            if (currentIndex < artworks.lastIndex) {
                currentIndex++
                updateArtwork()
            }
        }

        // Первоначальное отображение картины
        updateArtwork()
    }

    // Сохраняем текущую картину при повороте экрана
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("CURRENT_INDEX", currentIndex)
    }
}
