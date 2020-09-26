/**
 * Created by glenc on Sep 2020
 **/
class Foundation(val suit : String) {
    val cards:MutableList<Cards> = mutableListOf()


    //reset the game
    fun reset(){
        cards.clear()
    }

    // remove a specific card
    fun removeCard(card: Cards){
        cards.remove(card)
    }

    //add a card to foundation, if it holds a value greater that the current one
    // cards in foundation increment in value, according to solitaire rules
    fun addCard(card: Cards): Boolean{
        var nextCardValue =0;
        if (cards.size > 0){
            nextCardValue = cards.last().value + 1
        }
        if (card.suit == suit && card.value == nextCardValue){
            cards.add(card)
            return true
        }
        return false
    }


}