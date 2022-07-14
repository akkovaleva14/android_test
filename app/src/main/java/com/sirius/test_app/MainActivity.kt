package com.sirius.test_app

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sirius.test_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val data = DataModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onResume() {
        super.onResume()

        val reviewList = data.reviews
        val reviewAdapter = ReviewAdapter(reviewList)
        binding.recyclerView.adapter = reviewAdapter

        val tagList = data.tags
        val tagAdapter = TagAdapter(tagList)
        binding.recyclerView1.adapter = tagAdapter

        binding.gradeCnt1.text = getString(R.string.reviews1, data.gradeCnt)
        binding.gradeCnt.text = getString(R.string.reviews, data.gradeCnt)

        binding.name.text = data.name
        binding.rating.text = data.rating.toString()
        binding.description.text = data.description
        binding.btnInstall.text = data.action.name
        putPic(data.image, binding.image)
        putPic(R.drawable.logo, binding.logo) // изображение по ссылке - с ненужными краями!!!!!!


    }

    fun putPic(img: Any, holder: AppCompatImageView) {
        Glide
            .with(this)
            .load(img)
            .into(holder)
    }


}