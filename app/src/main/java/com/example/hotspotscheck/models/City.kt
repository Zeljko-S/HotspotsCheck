package com.example.hotspotscheck.models

data class City(val id: String, val name: String, val img: String, val hotspotimgs: List<String>, val hotstopnamelist: List<String>)

//data class Hotstop(val name: String, val img: String)


fun getCities(): List<City> {
    return listOf(
        City(
            id = "1",
            name = "New York",
            img = "https://www.godominicanrepublic.com/wp-content/uploads/2018/03/newyork-64819822_xxl.jpg",
            hotspotimgs = listOf("https://marvel-b1-cdn.bc0a.com/f00000000179470/www.esbnyc.com/sites/default/files/styles/small_feature/public/2019-10/home_banner-min.jpg?itok=uZt-03Vw",
            "https://media02.stockfood.com/largepreviews/MjE4MTA5NDM3Mw==/70357883-Tourists-Admiring-the-Panoramic-View-Over-Manhattan-From-the-Top-of-the-Rock-Observation-Deck-in-the-Ge.jpg",
            "https://cdn.getyourguide.com/img/tour/0dfe187f32955809.jpeg/146.jpg",
            "https://cdn.prod.www.spiegel.de/images/48f82c15-838c-4855-819a-ae641d8ca17b_w1200_r1.33_fpx72.57_fpy50.jpg",
            "https://blog.playandtour.com/wp-content/uploads/2017/03/nueva-york-central-park-zoo-delacorte-reloj.jpg",
            "https://afar-production.imgix.net/uploads/images/post_images/images/yLyRK7tDDk/original_9678f51ddef311fd9936ceea4ba264c0.jpg?1549376797?ixlib=rails-0.3.0&auto=format%2Ccompress&crop=entropy&fit=crop&h=719&q=80&w=954"
            ),
            hotstopnamelist = listOf("Empire State Building", "Top of the Rock", "Circle Line Cruise", "Edge", "Central Park Zoo", "NY Aquarium")

        ),
        City(
            id = "2",
            name = "London",
            img = "https://germanbackpacker.com/wp-content/uploads/2018/10/London-Eye-Preise-Erfahrungen-2-e1539963321177.jpg",
            hotspotimgs = listOf("https://bitmap.ticketlens.com/poi/265308607/1200x1200",
            "https://images-ext-1.discordapp.net/external/CpH1ll737YOXvEMIHLr5KGbEFxdGIdxG2MsjaSgElhQ/https/upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Natural_History_Museum_London_Jan_2006.jpg/800px-Natural_History_Museum_London_Jan_2006.jpg",
            "https://www.p.city-walks.info/London/Buckingham-Palace.jpg",
            "https://res.cloudinary.com/rebelwalls/image/upload/b_black,c_fill,f_auto,fl_progressive,h_533,q_auto,w_800/v1428566434/article/R11641_image1",
            "https://imgsrv2.voi.id/AqJDpiqhkIXkbcmeg2mDmEscRW2zCvy25JcGA0BO7A0/auto/1280/853/sm/1/bG9jYWw6Ly8vcHVibGlzaGVycy82NTk1LzIwMjAwNTMxMTUzNC1tYWluLmNyb3BwZWRfMTU5MDkxNDA5NC5qcGVn.jpg",
            "https://images-ext-2.discordapp.net/external/Eftr5986QhMF5EURR_Rl3vhpzX72pCBT7k5bqW1EoOM/https/mywowo.net/media/images/cache/londra_hyde_park_03_kensington_gardens_jpg_1200_630_cover_85.jpg?width=1166&height=612",
            ),
            hotstopnamelist = listOf("Trafalgar Square",  "Buckingham Palace", "Natural History Museum", "Tower Bridge", "Big Ben", "Hyde Park")
        ),
        City(
            id = "3",
            name = "Tokio",
            img = "https://www.falstaff.at/fileadmin/_processed_/7/1/csm_1-tokio-c-GettyImages-2640_22025df6c6.jpg",
            hotspotimgs = listOf("https://upload.wikimedia.org/wikipedia/commons/8/85/Meguro_River_Spring_2014%282%29.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/f/f3/Fountain_Yoyogipark.JPG",
            "https://oddviser.com/photo/place/1600/393.jpg",
            "https://i.pinimg.com/originals/24/28/e5/2428e5946542ba757c864117a3a2b298.jpg",
            "https://www.gotokyo.org/de/story/guide/shinjuku-shop/images/shopping_guide.jpg",
            "https://img.fotocommunity.com/sensoji-tempel-tokyo-a5dfad3c-6ffe-4ef3-ac70-2089acf5c6ce.jpg?height=1080"
            ),
            hotstopnamelist = listOf("Meguro River", "Yoyogi Park", "Chidorigafuchi", "Shinjuku Central Park", "Shinjuku", "Sensō-ji Tempel")
        )


    )
}