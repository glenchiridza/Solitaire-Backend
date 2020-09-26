/**
 * Created by glenc on Sep 2020
 **/
class Tableau(var cards: MutableList<Cards> = mutableListOf()) {
    init {
        if (cards.size > 0)
            cards.last().faceUp = true
    }

    //add current or new cards
    //check if it is lesser than the older card as by solitaire rule,
    // cards decrement  all the way down
    //if a card is king-- =12 add to the tableau
    fun addCards(currentCard:MutableList<Cards>): Boolean{

        if (cards.size > 0){
            if(currentCard.first().value  == cards.last().value -1
                && confirmSuit(currentCard,cards)){
                cards.addAll(currentCard)
                return true
            }else if (currentCard.first().value == 12){
                cards.addAll(currentCard)
                return true
            }
        }
        return false
    }

    //this is for suitCheck
    private fun confirmSuit(currentCard: MutableList<Cards>, oldCard: MutableList<Cards>): Boolean {

        if (arrayOfBlacks.contains(currentCard) && arrayOfReds.contains(oldCard) ||
                arrayOfReds.contains(currentCard) && arrayOfBlacks.contains(oldCard)){
            return true
        }
        return false
    }

    //remove card that was toggled
    fun removeCards(clicked: Int){
        for (i in clicked..cards.lastIndex){
            cards.removeAt(clicked)
        }
        //after removing card or as long as there are cards, turn faceup the last card
        if (cards.size > 0){
            cards.last().faceUp = true
        }
    }
}