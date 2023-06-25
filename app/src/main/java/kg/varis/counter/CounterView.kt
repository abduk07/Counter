package kg.varis.counter

interface CounterView {
    fun updateText(count:Int)
    fun showToast(message: String)
    fun changeTextColor(color: Int)
    fun resetTextColor()
}