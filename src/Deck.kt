/**
 * Created by glenc on Sep 2020
 **/

class Deck(){

    //create an array of Cards that will fill the deck
    //"it" is a variable provided automatically by
    private val cards = Array(52,){Cards(it%4, getSuit(it % 4))}

    //mutable list of cards in array
    var deckCards:MutableList<Cards> = cards.toMutableList();

    fun drawOutCard():Cards{
        return deckCards.removeAt(0)
    }

    fun resetGameDeck(){
        deckCards = cards.toMutableList()
        deckCards.forEach { it.faceUp = false }
        deckCards.shuffle()
    }




    private fun getSuit(i: Int): String {

        return when(i){
            0-> spades
            1-> diamonds
            2-> hearts
            else-> clubs
        }

    }
}