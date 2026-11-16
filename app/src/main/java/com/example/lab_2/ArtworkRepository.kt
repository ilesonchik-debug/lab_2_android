package com.example.lab_2

object ArtworkRepository {

    val artworks = listOf(

        Artwork(
            imageResource = R.drawable.s1,
            title = "Китайская стена",
            author = "Китай — строилась с III века до н. э..",
            description = "s1"
        ),

        Artwork(
            imageResource = R.drawable.s2,
            title = "Колизей",
            author = "Италия — открыт в 80 г. н. э..",
            description = "s2"
        ),

        Artwork(
            imageResource = R.drawable.s3,
            title = "Чичен-Ица",
            author = "Мексика - центр майя (I тысячелетие н. э.)",
            description = "s3"
        ),

        Artwork(
            imageResource = R.drawable.s4,
            title = "Мачу-Пикчу",
            author = "Перу — построен около 1440 года.",
            description = "s4"
        ),

        Artwork(
            imageResource = R.drawable.s5,
            title = "Тадж-Махал",
            author = "Индия - построен в 1632–1653 гг..",
            description = "s5"
        )
    )
}