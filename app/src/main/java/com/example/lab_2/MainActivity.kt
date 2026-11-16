package com.example.lab_2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentIndex = savedInstanceState?.getInt("CURRENT_INDEX") ?: 0

        val artworkImage = findViewById<ImageView>(R.id.artworkImage)
        val artworkTitle = findViewById<TextView>(R.id.artworkTitle)
        val artworkAuthor = findViewById<TextView>(R.id.artworkAuthor)

        val previousButton = findViewById<Button>(R.id.previousButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        val artworks = ArtworkRepository.artworks

        fun updateArtwork() {
            val artwork = artworks[currentIndex]

            artworkImage.setImageResource(artwork.imageResource)
            artworkImage.contentDescription = artwork.description

            artworkTitle.text = artwork.title
            artworkAuthor.text = artwork.author

            previousButton.isEnabled = currentIndex > 0
            nextButton.isEnabled = currentIndex < artworks.lastIndex
        }

        previousButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateArtwork()
            }
        }

        nextButton.setOnClickListener {
            if (currentIndex < artworks.lastIndex) {
                currentIndex++
                updateArtwork()
            }
        }

        updateArtwork()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("CURRENT_INDEX", currentIndex)
        super.onSaveInstanceState(outState)
    }
}