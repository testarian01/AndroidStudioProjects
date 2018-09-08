package tk.carabineer.toukenlist

data class Toukenlist(
        val code: Code
)

data class Code(
        val bunrui:String,
        val name:String,
        val nameyomi:String,
        val bikou:String
)


