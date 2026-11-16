package com.example.lab_2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Индекс текущей картины
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Восстанавливаем выбранную картину
        currentIndex = savedInstanceState?.getInt("CURRENT_INDEX") ?: 0

        // Находим элементы интерфейса
        val artworkImage = findViewById<ImageView>(R.id.artworkImage)
        val artworkTitle = findViewById<TextView>(R.id.artworkTitle)
        val artworkAuthor = findViewById<TextView>(R.id.artworkAuthor)

        val previousButton = findViewById<Button>(R.id.previousButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        // Получаем коллекцию картин
        val artworks = ArtworkRepository.artworks

        // Обновляем отображаемую картину
        fun updateArtwork() {

            val artwork = artworks[currentIndex]

            artworkImage.setImageResource(artwork.imageResource)

            // Получаем текст на текущем языке устройства
            artworkImage.contentDescription = getString(artwork.description)

            artworkTitle.text = getString(artwork.title)
            artworkAuthor.text = getString(artwork.author)

            // Управляем доступностью кнопок
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

    // Сохраняем выбранную картину при повороте экрана
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("CURRENT_INDEX", currentIndex)
        super.onSaveInstanceState(outState)
    }
}