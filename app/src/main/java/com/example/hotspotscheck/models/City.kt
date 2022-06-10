package com.example.hotspotscheck.models

import androidx.compose.runtime.Composable

data class City(val id: String, val name: String, val img: String, val hotspots: List<Hotspot>)

data class Hotspot(val id: String, val name: String, val img: String, val text: String)




fun getCities(): List<City> {
    return listOf(
        City(
            id = "1",
            name = "New York",
            img = "https://www.godominicanrepublic.com/wp-content/uploads/2018/03/newyork-64819822_xxl.jpg",
            hotspots = listOf(
            Hotspot(id = "1", name = "Empire State Building", img = "https://marvel-b1-cdn.bc0a.com/f00000000179470/www.esbnyc.com/sites/default/files/styles/small_feature/public/2019-10/home_banner-min.jpg?itok=uZt-03Vw", text = "Empire State Building, steel-framed skyscraper rising 102 stories that was completed in New York City in 1931 and was the tallest building in the world until 1971. The Empire State Building is located in Midtown Manhattan, on Fifth Avenue at 34th Street. It remains one of the most distinctive and famous buildings in the United States and is one of the best examples of Modernist Art Deco design."),
            Hotspot(id = "2", name = "Top of the Rock", img = "https://media02.stockfood.com/largepreviews/MjE4MTA5NDM3Mw==/70357883-Tourists-Admiring-the-Panoramic-View-Over-Manhattan-From-the-Top-of-the-Rock-Observation-Deck-in-the-Ge.jpg", text = "The views of NYC from Top of the Rock are not to be missed. Sharing the warm air and sweeping views of Central Park and Manhattan's Midtown and downtown skyscrapers with family and friends is an experience that is truly unforgettable."),
            Hotspot(id = "3", name = "Circle Line Cruise", img = "https://cdn.getyourguide.com/img/tour/0dfe187f32955809.jpeg/146.jpg", text = "Circle Line Sightseeing Cruises is a boat-based sightseeing and entertainment company in Manhattan, New York. Its principal business is operating guided tours of New York City from its base at Pier 83 in the Hell's Kitchen neighborhood."),
            Hotspot(id = "4", name = "Edge", img = "https://cdn.prod.www.spiegel.de/images/48f82c15-838c-4855-819a-ae641d8ca17b_w1200_r1.33_fpx72.57_fpy50.jpg", text = "Edge is the highest sky deck in the Western Hemisphere located at 30 Hudson Yards, with a one-of-a-kind design, it’s suspended in mid-air, giving you the feeling of floating in the sky with 360-degree views you can’t get anywhere else."),
            Hotspot(id = "5", name = "Central Park Zoo", img = "https://blog.playandtour.com/wp-content/uploads/2017/03/nueva-york-central-park-zoo-delacorte-reloj.jpg", text = "You will find over 130 species at the Central Park Zoo - from giant Grizzly Bears to tiny Leaf Cutter Ants."),
            Hotspot(id = "6", name = "NY Aquarium", img = "https://afar-production.imgix.net/uploads/images/post_images/images/yLyRK7tDDk/original_9678f51ddef311fd9936ceea4ba264c0.jpg?1549376797?ixlib=rails-0.3.0&auto=format%2Ccompress&crop=entropy&fit=crop&h=719&q=80&w=954", text = "The New York Aquarium is the oldest continually operating aquarium in the United States, located on the Riegelmann Boardwalk in Coney Island, Brooklyn, New York City. As of 2018, the New York Aquarium consists of five exhibits: Aquatheater; Conservation Hall; Sea Cliffs; Spineless; and Ocean Wonders: Sharks."),
            )
        ),
        City(
            id = "2",
            name = "London",
            img = "https://germanbackpacker.com/wp-content/uploads/2018/10/London-Eye-Preise-Erfahrungen-2-e1539963321177.jpg",
            hotspots = listOf(
                Hotspot(id = "1", name = "Trafalgar Square", img ="https://bitmap.ticketlens.com/poi/265308607/1200x1200", text = "The Trafalgar Square is one of London's most vibrant spaces in the middle of the city. Find out about the history of this heritage site, its statues and its fountains. Trafalgar Square is surrounded by museums, galleries, cultural spaces and historic buildings."),
                Hotspot(id = "2", name = "Buckingham Palace", img ="https://images-ext-1.discordapp.net/external/CpH1ll737YOXvEMIHLr5KGbEFxdGIdxG2MsjaSgElhQ/https/upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Natural_History_Museum_London_Jan_2006.jpg/800px-Natural_History_Museum_London_Jan_2006.jpg", text = "Buckingham Palace is recognised around the world as the home of The Queen, the focus of national and royal celebrations such as the Platinum Jubilee, as well as the backdrop to the regular Changing the Guard ceremony."),
                Hotspot(id = "3", name = "History Museum", img="https://www.p.city-walks.info/London/Buckingham-Palace.jpg", text = "Discover ancient civilisations, learn from the incredible achievements and challenges of people and societies past and present, and immerse yourself in the culture, languages, environments, people and debates of our ever-changing world. "),
                Hotspot(id = "4", name = "Tower Bridge", img="https://res.cloudinary.com/rebelwalls/image/upload/b_black,c_fill,f_auto,fl_progressive,h_533,q_auto,w_800/v1428566434/article/R11641_image1", text = "Tower Bridge crosses the Thames from the Tower of London in the north to Shad Thames on the South Bank. You can walk or drive across it, but for the best views, visit the exhibition to access the high level walkways. It’s also worth being on the riverbank when the bridge opens to allow tall-masted ships to pass through."),
                Hotspot(id = "5", name= "Big Ben", img="https://imgsrv2.voi.id/AqJDpiqhkIXkbcmeg2mDmEscRW2zCvy25JcGA0BO7A0/auto/1280/853/sm/1/bG9jYWw6Ly8vcHVibGlzaGVycy82NTk1LzIwMjAwNTMxMTUzNC1tYWluLmNyb3BwZWRfMTU5MDkxNDA5NC5qcGVn.jpg", text= "The Houses of Parliament and Elizabeth Tower, commonly called Big Ben, are among London's most iconic landmarks and must-see London attractions. Technically, Big Ben is the name given to the massive bell inside the clock tower, which weighs more than 13 tons.  The clock tower looks spectacular at night when the four clock faces are illuminated."),
                Hotspot(id = "6", name= "Hyde Park", img="https://images-ext-2.discordapp.net/external/Eftr5986QhMF5EURR_Rl3vhpzX72pCBT7k5bqW1EoOM/https/mywowo.net/media/images/cache/londra_hyde_park_03_kensington_gardens_jpg_1200_630_cover_85.jpg?width=1166&height=612", text= "Hyde Park covers 142 hectares (350 acres), making it the largest park in central London. It is the city’s most important green lung and where many tourists and residents come to relax and enjoy a bit of fresh air."),

                )
        ),
        City(
            id = "3",
            name = "Tokyo",
            img = "https://www.falstaff.at/fileadmin/_processed_/7/1/csm_1-tokio-c-GettyImages-2640_22025df6c6.jpg",
            hotspots = listOf(
                Hotspot(id = "1", name = "Meguro River", img = "https://upload.wikimedia.org/wikipedia/commons/8/85/Meguro_River_Spring_2014%282%29.jpg", text = "The Meguro River is a river which flows through Tokyo, Japan. Its tributaries include the Kitazawa River and the Karasuyama River. The river flows into Tokyo Bay near the Tennōzu Isle Station."),
                Hotspot(id = "2", name = "Yoyogi Park", img = "https://upload.wikimedia.org/wikipedia/commons/f/f3/Fountain_Yoyogipark.JPG", text = "Yoyogi Park is a park in Yoyogikamizonocho, Shibuya, Tokyo, Japan, located adjacent to Harajuku Station and Meiji Shrine. The park is a popular Tokyo destination. On Sundays, it is especially busy when it is used as a gathering place for Japanese rock music fans, jugglers, comedians, martial arts clubs, cosplayers and other subculture and hobby groups."),
                Hotspot(id = "3", name = "Chidorigafuchi", img = "https://oddviser.com/photo/place/1600/393.jpg", text = "The Chidorigafuchi Trench is one of the best places in Tokyo to see the cherry blossoms in spring, from late March to early April. This 700-meter walk next to the Imperial Palace moat offers beautiful scenery and great opportunities for discovery."),
                Hotspot(id = "4", name = "Shinjuku Central Park", img="https://i.pinimg.com/originals/24/28/e5/2428e5946542ba757c864117a3a2b298.jpg", text = "Shinjuku Central Park, Tokyo, Japan, covers an area of more than 80,000 square meters. The green area in Shinjuku is second only to Shijuku Gyoen National Garden, Meiji Jingu Gaien, and Toyama Park. It is also the park with the largest green area in Shinjuku District."),
                Hotspot(id = "5", name = "Shinjuku", img = "https://www.gotokyo.org/de/story/guide/shinjuku-shop/images/shopping_guide.jpg", text = "Shinjuku is one of the 23 city wards of Tokyo, but the name commonly refers to just the large entertainment, business and shopping area around Shinjuku Station. Shinjuku Station is the world's busiest railway station, handling more than two million passengers every day."),
                Hotspot(id = "6", name = "Sensō-ji Temple", img = "https://img.fotocommunity.com/sensoji-tempel-tokyo-a5dfad3c-6ffe-4ef3-ac70-2089acf5c6ce.jpg?height=1080", text = "Sensoji is a Buddhist temple located in Asakusa. It is one of Tokyo's most colorful and popular temples. The temple was completed in 645, making it Tokyo's oldest temple.")

            )
        )
    )
}