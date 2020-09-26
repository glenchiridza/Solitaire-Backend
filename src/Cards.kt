/**
 * Created by glenc on Sep 2020
 **/

//scoped to the entire project classes
const val hearts = "hearts"
const val diamonds = "diamonds"
const val clubs = "clubs"
const val spades = "spades"

val arrayOfReds = arrayOf(hearts,diamonds)
val arrayOfBlacks = arrayOf(clubs,spades)
val cardsMap = mapOf(0 to "A",1 to "2",2 to "3",3 to "4", 4 to "5", 5 to "6", 6 to "7", 7 to "8", 8 to "9",9 to "10", 10 to "J", 11 to "Q", 12 to "K")
data class Cards(val value:Int, val suit:String, var faceUp:Boolean=false){

    override fun toString(): String =
        if (faceUp) "${cardsMap.get(value)}".padEnd(2)+ getSuit(suit) else "###"

    private fun getSuit(suit: String): String {

       return when(suit){
            diamonds -> "\u2666"
           clubs -> "\u2663"
           hearts -> "\u2665"
           spades -> "\u2660"
           else -> "no such suit"

        }
    }
}
