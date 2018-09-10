package tk.carabineer.toukenlist

data class Toukenlist(
        val list01: list01,
        val list02: list02
)

data class list01(
        val bunrui:String,
        val name:String,
        val nameyomi:String,
        val bikou:String
)

data class list02(
        val bunrui:String,
        val name:String,
        val nameyomi:String,
        val bikou:String
)

