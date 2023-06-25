package kg.varis.counter

import android.graphics.Color

class Presenter {

    lateinit var view: CounterView
    var model = Model()

    fun increment() {
        model.increment()
        view.updateText(model.count)

        if (model.count == 10) {
            view.showToast("Congratulations!")
        }

        if (model.count >= 15) {
            view.changeTextColor(Color.GREEN)
        } else {
            view.resetTextColor()
        }
    }

    fun decrement() {
        model.decrement()
        view.updateText(model.count)
        if (model.count <= 14) {
            view.resetTextColor()
        }
    }

    fun init(view: CounterView) {
        this.view = view
    }
}