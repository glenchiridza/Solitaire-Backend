/**
 * Created by glenc on Sep 2020
 **/


fun main(args: Array<String>) {
    println("hello this is just for you to know values are being retrieved, \nin the end you will use the model in your front end project" +
            "be it Android or JavaFX , \nwherever kotlin fits, but l will implement the UI in android using Anko")

    Model.resetGame()
    Presenter.onDeckTap()
    Model.printPreview()

}