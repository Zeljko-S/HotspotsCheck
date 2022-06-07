package com.example.hotspotscheck.models

data class City(val id: String, val name: String, val img: String)

data class Hotstop(val name: String, val img: String)


fun getCities(): List<City> {
    return listOf(
        City(
            id = "1",
            name = "New York",
            img = "https://www.godominicanrepublic.com/wp-content/uploads/2018/03/newyork-64819822_xxl.jpg"
        ),
        City(
            id = "2",
            name = "London",
            img = "https://germanbackpacker.com/wp-content/uploads/2018/10/London-Eye-Preise-Erfahrungen-2-e1539963321177.jpg"
        ),
        City(
            id = "3",
            name = "Tokio",
            img = "https://www.falstaff.at/fileadmin/_processed_/7/1/csm_1-tokio-c-GettyImages-2640_22025df6c6.jpg"
        )

    )
}