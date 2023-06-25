package kg.varis.counter

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kg.varis.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    private lateinit var binding: ActivityMainBinding
    private val presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.init(this)
        initClick()
    }

    private fun initClick() = with(binding) {
        btnPlus.setOnClickListener {
            presenter.increment()
        }
        btnMinus.setOnClickListener {
            presenter.decrement()
        }
    }

    override fun updateText(count: Int) {
        binding.tvCount.text = count.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeTextColor(color: Int) {
        binding.tvCount.setTextColor(color)
    }

    override fun resetTextColor() {
        binding.tvCount.setTextColor(Color.BLACK)
    }
}