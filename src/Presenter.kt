/**
 * Created by glenc on Sep 2020
 **/
object Presenter {
    var view:MView? = null

    fun onDeckTap(){
        Model.tapDeck()
        view?.update()
    }

    fun onWasteTap(){
        Model.tapWastePile()
        view?.update()
    }


    fun foundationTap(index: Int)
    {
        Model.tapFoundation(index)
        view?.update()
    }


    fun tableauTap(tapIndex: Int, cardIndex: Int){
        Model.tapTableau(tapIndex,cardIndex)
        view?.update()
    }
}