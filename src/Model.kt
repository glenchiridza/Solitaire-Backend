/**
 * Created by glenc on Sep 2020
 **/
object Model {
    val deck = Deck()

    //wastepile to hold data in temporary view before playing
    var wastePile:MutableList<Cards> = mutableListOf()

    //foundation pile has 4 categories, thence the array of foundation
    val foundationPile:Array<Foundation> = arrayOf(
        Foundation(spades),
        Foundation(diamonds),
        Foundation(hearts),
        Foundation(clubs),
    )

    //tableau will contains & columns
    val tableauPile = Array(7){Tableau()}

    fun resetGame(){
        wastePile.clear()
        foundationPile.forEach { it.reset() }
        deck.resetGameDeck()

        //fill the tableau pile with cards from the deck until it reaches the 7th column
        tableauPile.forEachIndexed{i , tableau ->
            val cardsInTableau:MutableList<Cards> = Array(i+1){deck.drawOutCard()}.toMutableList()
            tableauPile[i] = Tableau(cardsInTableau)
        }
    }

    fun tapDeck(){
        if (deck.deckCards.size > 0){
            val card = deck.drawOutCard()
            card.faceUp = true
            wastePile.add(card)
        }else{
            deck.deckCards = wastePile.toMutableList()
            wastePile.clear()
        }
    }

    fun tapWastePile(){
        if (wastePile.size > 0){
            val card = wastePile.last()
            if (playCard(card)){
                wastePile.remove(card)
            }
        }
    }

    //remove the last indexed card on the foundation when tapped
    fun tapFoundation(index: Int)
    {
        val foundation = foundationPile[index]
        if (foundation.cards.size > 0){
            val card = foundation.cards.last()
            if (playCard(card)){
                foundation.removeCard(card)
            }
        }
    }

//    tableau has a card index[depends on column]  as well as a tap index [1thru7 columns]
    fun tapTableau(tapIndex: Int, cardIndex: Int){

    var tableauPile = tableauPile[tapIndex]
    if (tableauPile.cards.size > 0){
        val cards = tableauPile.cards
        if (playCards(cards)){
            tableauPile.removeCards(cardIndex)
        }
    }
}

    private fun playCards(cards: MutableList<Cards>): Boolean {

        //if there is only one card in the tableau then play it
        if (cards.size == 1){
            return playCard(cards.first())
        }
        else{
            tableauPile.forEach {
                if (it.addCards(cards)){
                    return true
                }
            }
        }
        return false
    }

    //play card to where ever possible, after tapWastePile
    private fun playCard(card: Cards): Boolean {
        foundationPile.forEach{
            if (it.addCard(card)){
                return true
            }
        }
        tableauPile.forEach {
            if (it.addCards(mutableListOf(card))){
                return true
            }
        }
        return false
    }

    fun printPreview(){
        println(deck.deckCards.last())
        var lineOne = if (wastePile.size > 0) "${wastePile.last()}" else "___"
        lineOne = lineOne.padEnd(18)
        foundationPile.forEach {
            lineOne += if (it.cards.size > 0) "${it.cards.last()}" else "___"
            lineOne += "   "
        }
        println(lineOne)
        println()

        //loop through tableau card rows for display
        for (i in 0..12){
            var row=""
            tableauPile.forEach {
                row += if (it.cards.size >i) "${it.cards[i]}" else "   "
                row += "   "
            }
            println(row)
        }
    }
}